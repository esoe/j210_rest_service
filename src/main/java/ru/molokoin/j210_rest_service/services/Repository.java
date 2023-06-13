package ru.molokoin.j210_rest_service.services;

import java.util.Collection;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Singleton
public class Repository implements RepositoryFace{
    @PersistenceContext (unitName="Repository")
    private EntityManager em;

    @Override
    public <T> Collection<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        //Metamodel m = em.getMetamodel();
        Root<T> obj = cq.from(clazz);
        return em.createQuery(cq.select(obj)).getResultList();
    }

    @Override
    public <T> T findById(Class<T> clazz, Integer id) {
        return em.find(clazz, id);
    }

    @Override
    public <T> void delete(Class<T> clazz, Integer id) {
        T entity = em.find(clazz, id);
        em.remove(entity);
    }

    @Override
    public <T> void save(T entity) {
        em.persist(entity);
    }

    @Override
    public <T> void update(T entity) {
        em.merge(entity);
        em.flush();
    }
    
}
