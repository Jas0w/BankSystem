package ru.pinchuk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinchuk.entity.BankAccount;
import ru.pinchuk.repository.BankAccountRepository;
import ru.pinchuk.service.BankAccountService;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public void deleteBankAccount(Long id) {
        bankAccountRepository.delete(id);
    }

    @Override
    public BankAccount editBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

//    @Override
//    public List<BankAccount> getAccountsByClientId(Long clientId) {
//        return bankAccountRepository.getAccountsByClientId(clientId);
//    }
}
