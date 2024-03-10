package br.com.ccs.ejpa.repositories;

import br.com.ccs.ejpa.entities.Produto;
import jakarta.persistence.Persistence;

public class BaseRepositoty {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("Ecommerce-PU");
        var em = entityManagerFactory.createEntityManager();

        var p = em.find(Produto.class, 1);
        System.out.println(p.getNome().concat(" R$").concat(p.getPreco().toString()));

        em.close();
        entityManagerFactory.close();
    }
}
