package com.fr.amire.services;

import com.fr.amire.beans.AccountSessionBean;
import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AuthenticationService {

    @EJB
    private AccountSessionBean accountSessionBean;

    public boolean authenticate(String username, String password) {
        AccountEntity account = accountSessionBean.findByUsername(username);
        return account != null && account.getPassword().equals(password);
    }
}
