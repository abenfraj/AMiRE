package com.fr.amire.repositories;

import com.fr.amire.entities.CandidatureEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.ApiException.ERROR_WHILE_UPDATING;

@Stateless
public class CandidatureRepository {
    private static final Logger LOGGER = Logger.getLogger(CandidatureRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<CandidatureEntity> getAllCandidatures() {
        Query q = em.createQuery("select candidatures from AnnonceEntity candidatures");
        return q.getResultList();
    }

    public List<CandidatureEntity> getCandidaturesByOfferId(int idAnnonce) {
        try {
            return em.createQuery("SELECT c FROM CandidatureEntity c WHERE c.annonce.idAnnonce = :idAnnonce", CandidatureEntity.class)
                    .setParameter("idAnnonce", idAnnonce)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.warning("No result found for offerId: " + idAnnonce);
            return null;
        }
    }

    public void save(CandidatureEntity candidature) {
        em.getTransaction().begin();
        em.merge(candidature);
        em.getTransaction().commit();
    }

    public boolean updateCandidature(int idCandidature, CandidatureEntity updatedCandidature) {
        try {
            em.getTransaction().begin();

            CandidatureEntity existingCandidature = em.find(CandidatureEntity.class, idCandidature);

            if (existingCandidature != null) {
                existingCandidature.setContacteParPersonne(updatedCandidature.getContacteParPersonne());
                existingCandidature.setContacteLe(updatedCandidature.getContacteLe());
                existingCandidature.setDecision(updatedCandidature.getDecision());

                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_WHILE_UPDATING, e);
            em.getTransaction().rollback();
            return false;
        }
    }

    public CandidatureEntity getCandidatureById(int idCandidature) {
        try {
            return em.createQuery("SELECT c FROM CandidatureEntity c WHERE c.idCandidature = :idCandidature", CandidatureEntity.class)
                    .setParameter("idCandidature", idCandidature)
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.warning("No result found for offerId: " + idCandidature);
            return null;
        }
    }

    public List<CandidatureEntity> getCandidaturesByEnseignantId(int idEnseignant) {
        try {
            return em.createQuery(
                    "SELECT c FROM CandidatureEntity c JOIN FETCH c.annonce WHERE c.idEnseignant = :idEnseignant"
                            , CandidatureEntity.class)
                    .setParameter("idEnseignant", idEnseignant)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.warning("No result found for enseignantId: " + idEnseignant);
            return null;
        }
    }
}
