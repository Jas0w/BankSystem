package ru.pinchuk.service;

import ru.pinchuk.entity.Bank;

import java.util.List;

public interface BankService {
    Bank addBank(Bank bank);
    void delete(Long id);
    Bank getByName(String name);
    Bank editBank(Bank bank);
    List<Bank> getAll();
    Bank getById(Long id);
}
