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
        Query q = em.createQuery("select enseignants from EnseignantEntity enseignants where enseignants.idenseignant = :id");
        q.setParameter("id", id);
        return (EnseignantEntity) q.getSingleResult();
    }

    public boolean updateEnseignant(int id, EnseignantEntity enseignantOutput) {
        try {
            em.getTransaction().begin();

            EnseignantEntity enseignant = em.find(EnseignantEntity.class, id);
            if (enseignant == null) {
                em.getTransaction().rollback();
                return false;
            }

            enseignant.setNomEnseignant(enseignantOutput.getNomEnseignant());
            enseignant.setPrenomEnseignant(enseignantOutput.getPrenomEnseignant());
            enseignant.setSiteWeb(enseignantOutput.getSiteWeb());
            enseignant.setEmail(enseignantOutput.getEmail());
            enseignant.setTelephone(enseignantOutput.getTelephone());
            enseignant.setTypeDeContrat(enseignantOutput.getTypeDeContrat());
            enseignant.setDisponibilites(enseignantOutput.getDisponibilites());
            enseignant.setCompetences(enseignantOutput.getCompetences());
            enseignant.setInteretEcole(enseignantOutput.getInteretEcole());
            enseignant.setInteretDomaines(enseignantOutput.getInteretDomaines());
            enseignant.setNiveauxSouhaites(enseignantOutput.getNiveauxSouhaites());
            enseignant.setExperience(enseignantOutput.getExperience());
            enseignant.setTitresAcademiques(enseignantOutput.getTitresAcademiques());
            enseignant.setDivers(enseignantOutput.getDivers());
            enseignant.setRecommandations(enseignantOutput.getRecommandations());
            enseignant.setEvaluation(enseignantOutput.getEvaluation());

            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_WHILE_UPDATING + "enseignant", e);
            em.getTransaction().rollback();
            return false;
        }
    }

}
