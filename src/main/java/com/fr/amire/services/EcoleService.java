package com.fr.amire.services;

import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.repositories.EcoleRepository;
import jakarta.ejb.EJB;

import java.util.List;

public class EcoleService {
    @EJB
    private EcoleRepository ecoleRepository;

    public EcoleService() {
        this.ecoleRepository = new EcoleRepository();
    }

    public List<EcoleEntity> getAllEcoles() {
        return ecoleRepository.getAllEcoles();
    }

    public EcoleEntity getEcoleById(int id) {
        return ecoleRepository.getEcoleById(id);
    }

    public void save(EcoleEntity ecole) {
            ecoleRepository.save(ecole);
    }

    public void deleteEcole(String id) {
        ecoleRepository.deleteEcole(id);
    }
}
