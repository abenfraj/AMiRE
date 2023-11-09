package com.fr.amire.repositories;

import com.fr.amire.entities.EcoleEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.ApiException.ERROR_WHILE_CREATING;

@Stateless
public class EcoleRepository {
    private static final Logger LOGGER = Logger.getLogger(EcoleRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<EcoleEntity> getAllEcoles() {
        Query q = em.createQuery("select ecoles from EcoleEntity ecoles");
        return q.getResultList();
    }

    public EcoleEntity getEcoleById(int id) {
        Query q = em.createQuery("select ecoles from EcoleEntity ecoles where ecoles.idEcole = :id");
        q.setParameter("id", id);
        return (EcoleEntity) q.getSingleResult();
    }

    public void save(EcoleEntity ecole) {
        try {
            em.getTransaction().begin();
            em.persist(ecole);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_WHILE_CREATING, e);
            em.getTransaction().rollback();
        }
    }

}
