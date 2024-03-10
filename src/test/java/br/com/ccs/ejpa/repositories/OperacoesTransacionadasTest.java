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
        assertEquals(2, produto.getId());
        assertNull(produto.getNome());
        assertNull(produto.getDescricao());
    }

    @Test
    void removerObjeto() {
        var p = em.find(Produto.class, 3);
        begin();
        em.remove(p);
        commit();

        p = em.find(Produto.class, p.getId());

        assertNull(p);
    }
}
