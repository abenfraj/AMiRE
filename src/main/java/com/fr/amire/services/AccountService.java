package com.fr.amire.services;

import com.fr.amire.repositories.AccountRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AccountService {

    @EJB
    private AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public String getTypeForAccount(int accountId) {
        if (accountRepository.existsInEcole(accountId)) {
            return "Ecole";
        } else if (accountRepository.existsInEnseignant(accountId)) {
            return "Enseignant";
        }
        return "Admin";
    }
}
