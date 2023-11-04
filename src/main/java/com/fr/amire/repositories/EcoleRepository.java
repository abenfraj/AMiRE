package com.fr.amire.repositories;

import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EcoleRepository {
    private static final Logger LOGGER = Logger.getLogger(EcoleRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAllEcoles() {
        Query q = em.createQuery("select ecoles from AnnonceEntity ecoles");
        return q.getResultList();
    }
}
