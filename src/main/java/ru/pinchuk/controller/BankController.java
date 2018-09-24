package ru.pinchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pinchuk.entity.Bank;
import ru.pinchuk.service.BankService;

import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping(value = "/banks")
    public ModelAndView listOfBanks() {
        List<Bank> banks = bankService.getAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "List of banks");
        modelAndView.addObject("banks", banks);

        modelAndView.setViewName("bank/listOfBanks");

        return modelAndView;
    }

    @GetMapping(value = "/addBank")
    public ModelAndView createNewBank() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newBank", new Bank());

        modelAndView.setViewName("bank/addBank");

        return modelAndView;
    }

    @PostMapping(value = "/addBank")
    public ModelAndView saveNewBank(@ModelAttribute("SpringWeb")Bank newBank) {
        bankService.addBank(newBank);

        return new ModelAndView("redirect:/banks");
    }

}
