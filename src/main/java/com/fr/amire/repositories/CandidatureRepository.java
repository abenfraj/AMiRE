package com.fr.amire.repositories;

import jakarta.ejb.Stateless;
import com.fr.amire.entities.CandidatureEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CandidatureRepository {
    private static final Logger LOGGER = Logger.getLogger(CandidatureRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<CandidatureEntity> getAllCandidatures() {
        Query q = em.createQuery("select candidatures from AnnonceEntity candidatures");
        return q.getResultList();
    }

    public CandidatureEntity getCandidatureByOfferId(int idCandidature) {
        try {
            return em.createQuery("SELECT c FROM CandidatureEntity c WHERE c.idCandidature = :idCandidature", CandidatureEntity.class)
                    .setParameter("idCandidature", idCandidature)
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.warning("No result found for offerId: " + idCandidature);
            return null;
        }
    }

    public void save(CandidatureEntity candidature) {
        em.getTransaction().begin();
        em.persist(candidature);
        em.getTransaction().commit();
    }
}
