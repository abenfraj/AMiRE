package com.fr.amire.repositories;

import com.fr.amire.entities.AnnonceEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AnnonceRepository {
    private static final Logger LOGGER = Logger.getLogger(AnnonceRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AnnonceEntity> getAllAnnonces() {
        Query q = em.createQuery("select annonces from AnnonceEntity annonces");
        return q.getResultList();
    }

    public List<AnnonceEntity> searchAnnonces(String searchQuery) {
        try {
            return em.createQuery("SELECT a FROM AnnonceEntity a WHERE a.titre LIKE :searchQuery OR a.description LIKE :searchQuery", AnnonceEntity.class)
                    .setParameter("searchQuery", "%" + searchQuery + "%")
                    .getResultList();
        } catch (Exception e) {
            LOGGER.warning("No result found for searchQuery: " + searchQuery);
            return null;
        }
    }
}
