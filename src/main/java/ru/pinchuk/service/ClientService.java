package ru.pinchuk.service;

import ru.pinchuk.entity.BankAccount;
import ru.pinchuk.entity.Client;

import java.util.List;
import java.util.Set;

public interface ClientService {

    Client addClient(Client client);
    void deleteClient(Long id);
    Client editClient(Client client);
    List<Client> getAll();
    List<Client> getClientsByBankId(Long id);
    Client getClientById(Long id);
}
