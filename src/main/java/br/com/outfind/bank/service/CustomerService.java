package br.com.outfind.bank.service;

import br.com.outfind.bank.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer() {

        Customer customer = new Customer();

        customer.setId(1L);
        customer.setFullName("Gilvan Menezes");
        customer.setCpf("12345678900");
        customer.setEmail("gilvan@email.com");
        customer.setPhone("13999999999");

        return customer;
    }
}