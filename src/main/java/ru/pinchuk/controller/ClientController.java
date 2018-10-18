package ru.pinchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pinchuk.entity.Client;
import ru.pinchuk.service.BankAccountService;
import ru.pinchuk.service.BankService;
import ru.pinchuk.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankService bankService;


    @GetMapping(value = "/banks/{bankId}/clients")
    public ModelAndView getClientsByBankId(@PathVariable Long bankId) {
        List<Client> clientsByBankId = clientService.getClientsByBankId(bankId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clients", clientsByBankId);
        modelAndView.setViewName("client/listOfClients");

        return modelAndView;
    }

    @GetMapping(value = "/banks/{bankId}/clients/{id}")
    public ModelAndView getClientById(@PathVariable Long id) {
        Client clientById = clientService.getClientById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", clientById);
        modelAndView.setViewName("client/clientInfo");

        return modelAndView;
    }


    @GetMapping(value = "/banks/{bankId}/addClient")
    public ModelAndView createNewClient(ModelAndView modelAndView) {
        modelAndView.addObject("newClient", new Client());
        modelAndView.setViewName("client/addClient");

        return modelAndView;
    }

    @PostMapping(value = "/banks/{bankId}/addClient")
    @Transactional
    public ModelAndView saveNewClient(
            @ModelAttribute("newClient") @Valid Client newClient,
            BindingResult result,
            @PathVariable Long bankId
            ) {


        if(result.hasErrors()) {
            return new ModelAndView("client/addClient");
        }

        newClient.setBank(bankService.getById(bankId));
        clientService.addClient(newClient);
        
        return new ModelAndView("redirect:/banks/"+bankId+"/clients");
    }

    @GetMapping(value = "/banks/{bankId}/clients/{clientId}/delete")
    public ModelAndView deleteClient(@PathVariable Long bankId, @PathVariable Long clientId) {
        clientService.deleteClient(clientId);

        return new ModelAndView("redirect:/banks/"+bankId+"/clients");
    }

    @GetMapping(value = "/banks/{bankId}/clients/{clientId}/accounts")
    public ModelAndView getAccounts(@PathVariable Long clientId) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("accounts", bankAccountService.getAccountsByClientId(clientId));
        modelAndView.setViewName("client/accounts");

        return modelAndView;
    }
}
