package com.fr.amire;

import com.fr.amire.entities.AnnonceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;

public class AnnonceSessionBean {
    private static final Logger LOGGER = Logger.getLogger(AnnonceSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();
}
