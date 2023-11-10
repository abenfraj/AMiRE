package com.fr.amire.repositories;

import com.fr.amire.entities.EnseignantEntity;
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
public class EnseignantRepository {

    private static final Logger LOGGER = Logger.getLogger(EnseignantRepository.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<EnseignantEntity> getAllEnseignants() {
        Query q = em.createQuery("select enseignants from EnseignantEntity enseignants");
        return q.getResultList();
    }

    public EnseignantEntity getEnseignantById(int id) {
        Query q = em.createQuery("select enseignants from EnseignantEntity enseignants where enseignants.idEnseignant = :id");
        q.setParameter("id", id);
        return (EnseignantEntity) q.getSingleResult();
    }

    public boolean updateEnseignant(int id, EnseignantEntity enseignantOutput) {
        try {
            em.getTransaction().begin();
            //EnseignantEntity enseignant = em.find(EnseignantEntity.class, enseignantOutput.getIdEnseignant());
            // enseignant.setNom(enseignantOutput.getNom());
            // enseignant.setPrenom(enseignantOutput.getPrenom());
            // enseignant.setAdresse(enseignantOutput.getAdresse());
            // enseignant.setStatut(enseignantOutput.getStatut());
            // enseignant.setDepartement(enseignantOutput.getDepartement());
            // enseignant.setLaboratoire(enseignantOutput.getLaboratoire());
            //enseignant.setTelephone(enseignantOutput.getTelephone());
            //enseignant.setEmail(enseignantOutput.getEmail());
            //enseignant.setSiteWeb(enseignantOutput.getSiteWeb());
            em.merge(enseignantOutput);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_WHILE_UPDATING + "enseignant", e);
            em.getTransaction().rollback();
            return false;
        }
    }

}
