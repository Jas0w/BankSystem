package ru.pinchuk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinchuk.entity.Bank;
import ru.pinchuk.repository.BankRepository;
import ru.pinchuk.service.BankService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bank addBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public void delete(Long id) {
        bankRepository.delete(id);
    }

    @Override
    public Bank getByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public Bank editBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getById(Long id) {
        return bankRepository.findById(id);
    }
}
