package com.fr.amire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;

public class EnseignantSessionBean {
    private static final Logger LOGGER = Logger.getLogger(EnseignantSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

}
