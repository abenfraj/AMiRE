package com.amire.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AuthenticationService {

    @PersistenceContext
    private EntityManager em;


}
