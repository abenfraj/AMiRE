package com.fr.amire.services;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.repositories.AnnonceRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AnnonceService {

    @EJB
    private AnnonceRepository annonceRepository;

    public AnnonceService() {
        this.annonceRepository = new AnnonceRepository();
    }

    public List<AnnonceEntity> getAllAnnonces() {
        return annonceRepository.getAllAnnonces();
    }

    public List<AnnonceEntity> searchAnnonces(String searchQuery) {
        return annonceRepository.searchAnnonces(searchQuery);
    }
}
