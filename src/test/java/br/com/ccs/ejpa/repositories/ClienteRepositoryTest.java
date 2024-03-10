package br.com.ccs.ejpa.repositories;

import br.com.ccs.ejpa.entities.Cliente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteRepositoryTest {

    private static final ClienteRepository repository = new ClienteRepository();

    @Test
    @Order(1)
    void salvar() {
        var cliente = new Cliente();
        cliente.setNome("Joao");
        cliente.setId(10);

        assertDoesNotThrow(() -> repository.persist(cliente));
    }

    @Test
    @Order(2)
    void find() {
        repository.getEntityManager().clear();

        var cliente = repository.findById(10L);

        assertNotNull(cliente);
        assertEquals(10, cliente.getId());
        assertEquals("Joao", cliente.getNome());
    }

    @Test
    @Order(3)
    void update() {
        repository.getEntityManager().clear();
        var cliente = repository.findById(10L);
        cliente.setNome("Maria");

        assertDoesNotThrow(() -> repository.merge(cliente));
        assertEquals("Maria", cliente.getNome());
        assertEquals(10, cliente.getId());
    }

    @Test
    void remove() {
        repository.getEntityManager().clear();
        var cliente = repository.findById(10L);

        assertDoesNotThrow(() -> repository.remove(cliente));
        assertNull(repository.findById(10L));
    }
}