package com.fr.amire.services;

import com.fr.amire.repositories.AccountRepository;
import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AuthenticationService {

    @EJB
    private AccountRepository accountRepository;

    public boolean authenticate(String username, String password) {
        AccountEntity account = accountRepository.findByUsername(username);
        return account != null && account.getPassword().equals(password);
    }

    public AccountEntity getAccount(String username) {
        return accountRepository.findByUsername(username);
    }
}
