package ru.pinchuk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinchuk.entity.Client;
import ru.pinchuk.entity.Employee;
import ru.pinchuk.repository.ClientRepository;
import ru.pinchuk.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClientsByBankId(Long id) {
        return clientRepository.findClientsByBankId(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.getClientById(id);
    }
}
