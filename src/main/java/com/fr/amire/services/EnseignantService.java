package com.fr.amire.services;

import com.fr.amire.entities.EnseignantEntity;
import com.fr.amire.repositories.EnseignantRepository;
import jakarta.ejb.EJB;

import java.util.List;

public class EnseignantService {
    @EJB
    private EnseignantRepository enseignantRepository;

    public EnseignantService() {
        this.enseignantRepository = new EnseignantRepository();
    }

    public List<EnseignantEntity> getAllEnseigannts() {
        return enseignantRepository.getAllEnseignants();
    }

    public EnseignantEntity getEnseignantById(int id) {
        return enseignantRepository.getEnseignantById(id);
    }

    public boolean updateEnseignant(int id, EnseignantEntity enseignantOutput) {
        return enseignantRepository.updateEnseignant(id, enseignantOutput);
    }
}
