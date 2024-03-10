package br.com.ccs.ejpa.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class BaseRepositoryTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager em;

    @BeforeAll
    static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @BeforeEach
    void beforeEach() {
        em = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    void afterEach() {
        em.close();
    }

    protected void begin() {
        em.getTransaction().begin();
    }

    protected void commit() {
        em.getTransaction().commit();
    }
}