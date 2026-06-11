package br.com.outfind.bank.service;

import br.com.outfind.bank.dto.CustomerRequestDTO;
import br.com.outfind.bank.dto.CustomerResponseDTO;
import br.com.outfind.bank.entity.Customer;
import br.com.outfind.bank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setCpf(dto.getCpf());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        Customer saved = repository.save(customer);

        return new CustomerResponseDTO(
                saved.getId(),
                saved.getFullName(),
                saved.getEmail()
        );
    }

    public List<CustomerResponseDTO> getCustomers() {
        return repository.findAll()
                .stream()
                .map(c -> new CustomerResponseDTO(
                        c.getId(),
                        c.getFullName(),
                        c.getEmail()
                ))
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail()
        );
    }

    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setFullName(dto.getFullName());
        customer.setCpf(dto.getCpf());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        Customer updated = repository.save(customer);

        return new CustomerResponseDTO(
                updated.getId(),
                updated.getFullName(),
                updated.getEmail()
        );
    }

    public void deleteCustomer(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        repository.delete(customer);
    }

    
}