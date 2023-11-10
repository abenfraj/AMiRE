package com.fr.amire.services;

import com.fr.amire.entities.AccountEntity;
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

    public void saveAccount(AccountEntity account) {
        accountRepository.save(account);
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
