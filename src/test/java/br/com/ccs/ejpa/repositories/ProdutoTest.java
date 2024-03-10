package br.com.ccs.ejpa.repositories;

import br.com.ccs.ejpa.entities.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest extends BaseRepositotyTest {

    @Test
    void findById() {
        var produto = em.find(Produto.class, 1);
        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());
    }

    /**
     * {@link jakarta.persistence.EntityManager#getReference(Class, Object)}
     * só executa o select quando algum atributo da entidade for utilizado.
     */
    @Test
    void findByReference() {
        var produto = em.getReference(Produto.class, 1);
        Assertions.assertNotNull(produto);
        System.out.println("agora vai no banco!!!");
        Assertions.assertEquals("Kindle", produto.getNome());
    }

    /**
     * {@link jakarta.persistence.EntityManager#refresh(Object)}
     * consulta no banco novamente e volta a entidade ao estado
     * que estava no banco de dados.
     */
    @Test
    void refresh() {
        var produto = em.find(Produto.class, 1);
        produto.setNome("ashdlajsdljaslj");

        em.refresh(produto);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());
    }
}
