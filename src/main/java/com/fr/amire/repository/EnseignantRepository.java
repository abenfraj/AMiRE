package com.fr.amire.repository;

import com.fr.amire.entities.AccountEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

public class EnseignantRepository {
    private static final Logger LOGGER = Logger.getLogger(EnseignantRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAllEnseignants() {
        Query q = em.createQuery("select enseignants from AnnonceEntity enseignants");
        return q.getResultList();
    }
}
