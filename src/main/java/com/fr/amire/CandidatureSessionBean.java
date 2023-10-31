package com.fr.amire;

import com.fr.amire.entities.AccountEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

public class CandidatureSessionBean {
    private static final Logger LOGGER = Logger.getLogger(CandidatureSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAllCandidatures() {
        Query q = em.createQuery("select candidatures from AnnonceEntity candidatures");
        return q.getResultList();
    }
}
