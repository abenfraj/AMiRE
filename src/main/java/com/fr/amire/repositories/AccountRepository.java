package com.fr.amire.repositories;

import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AccountRepository {

    private static final Logger LOGGER = Logger.getLogger(AccountRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAll() {
        Query q = em.createQuery("select e from AccountEntity e");
        return q.getResultList();
    }

    public AccountEntity findByUsername(String username) {
        try {
            return em.createQuery("SELECT a FROM AccountEntity a WHERE a.username = :username", AccountEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            LOGGER.warning("No result found for username: " + username);
            return null;
        }
    }
}