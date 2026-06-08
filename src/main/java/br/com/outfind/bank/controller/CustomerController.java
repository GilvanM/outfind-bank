package br.com.outfind.bank.controller;

import br.com.outfind.bank.entity.Customer;
import br.com.outfind.bank.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Customer getCustomer() {
        return customerService.getCustomer();
    }
}