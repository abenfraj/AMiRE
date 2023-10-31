package com.fr.amire;

import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AccountSessionBean {

    private static final Logger LOGGER = Logger.getLogger(AccountSessionBean.class.getName());

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<AccountEntity> getAllAccounts() {
        Query q = em.createQuery("select e from AccountEntity e");
        return q.getResultList();
    }
}