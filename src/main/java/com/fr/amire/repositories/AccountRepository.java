package com.fr.amire.repositories;

import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
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
            return em.createQuery("SELECT a FROM AccountEntity a WHERE a.name = :username", AccountEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            LOGGER.warning("No result found for username: " + username);
            return null;
        }
    }

    public boolean existsInEcole(int accountId) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a.ecole.idEcole) FROM AccountEntity a WHERE a.id = :accountId", Long.class
        );
        query.setParameter("accountId", accountId);
        Long count = query.getSingleResult();
        return count > 0;
    }

    public boolean existsInEnseignant(int accountId) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a.enseignant.idEnseignant) FROM AccountEntity a WHERE a.id = :accountId", Long.class
        );
        query.setParameter("accountId", accountId);
        Long count = query.getSingleResult();
        return count > 0;
    }

    public void save(AccountEntity account) {
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while saving account", e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
}