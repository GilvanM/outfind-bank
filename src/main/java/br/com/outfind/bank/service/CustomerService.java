package br.com.outfind.bank.service;

import br.com.outfind.bank.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public List<Customer> getCustomers() {

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFullName("Gilvan Menezes");
        customer1.setCpf("12345678900");
        customer1.setEmail("gilvan@email.com");
        customer1.setPhone("13999999999");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFullName("Natalia Vitoria");
        customer2.setCpf("98765432100");
        customer2.setEmail("natalia@email.com");
        customer2.setPhone("13988888888");

        customers.add(customer1);
        customers.add(customer2);

        return customers;
    }
}