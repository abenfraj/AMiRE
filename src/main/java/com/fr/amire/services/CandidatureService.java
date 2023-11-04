package com.fr.amire.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.repositories.CandidatureRepository;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
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

    public CandidatureEntity getCandidatureByOfferId(int idCandidature) {
        return candidatureRepository.getCandidatureByOfferId(idCandidature);
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
}
