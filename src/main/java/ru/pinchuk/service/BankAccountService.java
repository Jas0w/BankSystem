package ru.pinchuk.service;

import ru.pinchuk.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccount addBankAccount(BankAccount bankAccount);
    void deleteBankAccount(Long id);
    BankAccount editBankAccount(BankAccount bankAccount);
    List<BankAccount> getAll();
//    List<BankAccount> getAccountsByClientId(Long clientId);
}
