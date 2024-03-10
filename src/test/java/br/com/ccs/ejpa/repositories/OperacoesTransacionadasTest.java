package br.com.ccs.ejpa.repositories;

import br.com.ccs.ejpa.entities.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperacoesTransacionadasTest extends BaseRepositotyTest {

    @Test
    void abrirFecharTransacao() {

        Produto produto = new Produto();
        produto.setId(2);
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        em.refresh(produto);

        assertNotNull(produto);
        assertEquals(produto.getId(), produto.getId());
        assertNull(produto.getNome());
        assertNull(produto.getDescricao());
    }
}
