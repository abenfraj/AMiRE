package com.fr.amire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;

public class CandidatureSessionBean {
    private static final Logger LOGGER = Logger.getLogger(CandidatureSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

}
