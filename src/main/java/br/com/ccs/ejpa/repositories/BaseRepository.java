package br.com.ccs.ejpa.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.lang.reflect.ParameterizedType;

public class BaseRepository<T> {

    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Ecommerce-PU");
    private final EntityManager em = entityManagerFactory.createEntityManager();

    protected void begin() {
        em.getTransaction().begin();
    }

    protected void commit() {
        em.getTransaction().commit();
    }

    public void persist(T entity) {
        begin();
        em.persist(entity);
        commit();
    }

    public T findById(Long id) {
        return em.find(getEntityClass(), id);
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public T merge(T entity) {
        begin();
        entity = em.merge(entity);
        commit();
        return entity;
    }

    public void remove(T entity) {
        begin();
        em.remove(entity);
        commit();
    }
    public EntityManager getEntityManager(){
        return em;
    }
}
