package com.fr.amire.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.repositories.CandidatureRepository;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class CandidatureService {
    @EJB
    private CandidatureRepository candidatureRepository;

    public CandidatureService() {
        this.candidatureRepository = new CandidatureRepository();
    }

    public List<CandidatureEntity> getAllCandidatures() {
        return candidatureRepository.getAllCandidatures();
    }

    public List<CandidatureEntity> getCandidaturesByOfferId(int idAnnonce) {
        return candidatureRepository.getCandidaturesByOfferId(idAnnonce);
    }

    public boolean saveCandidature(CandidatureEntity candidature) {
        try {
            candidatureRepository.save(candidature);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CandidatureEntity parseCandidatureFromRequest(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(request.getReader(), CandidatureEntity.class);
    }

    public boolean updateCandidature(int idCandidature, CandidatureEntity candidatureFromBody) {
        return candidatureRepository.updateCandidature(idCandidature, candidatureFromBody);
    }

    public CandidatureEntity getCandidatureById(int idCandidature) {
        return candidatureRepository.getCandidatureById(idCandidature);
    }

    public List<CandidatureEntity> getCandidaturesByEnseignantId(int idEnseignant) {
        return candidatureRepository.getCandidaturesByEnseignantId(idEnseignant);
    }
}
