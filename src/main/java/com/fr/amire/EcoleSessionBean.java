package com.fr.amire;

import com.fr.amire.entities.AccountEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

public class EcoleSessionBean {
    private static final Logger LOGGER = Logger.getLogger(EcoleSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAllEcoles() {
        Query q = em.createQuery("select ecoles from AnnonceEntity ecoles");
        return q.getResultList();
    }
}
