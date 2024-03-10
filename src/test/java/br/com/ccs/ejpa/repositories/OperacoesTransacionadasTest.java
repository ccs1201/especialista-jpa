package br.com.ccs.ejpa.repositories;

import br.com.ccs.ejpa.entities.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        var p = em.find(Produto.class, 1);
        begin();
        em.remove(p);
        commit();

        p = em.find(Produto.class, p.getId());

        assertNull(p);
    }

    @Test
    void updateObjeto() {

        var p = em.find(Produto.class, 2);
        p.setNome("teste");
        p.setDescricao("descricao");
        p.setPreco(BigDecimal.valueOf(10.00).setScale(2));

        begin();
        em.merge(p);
        commit();

        em.clear();

        var actual = em.find(Produto.class, p.getId());

        assertNotNull(p);

        assertEquals(p.getId(), actual.getId());
        assertEquals(p.getNome(), actual.getNome());
        assertEquals(p.getDescricao(), actual.getDescricao());
        assertEquals(p.getPreco(), actual.getPreco());

    }
}
