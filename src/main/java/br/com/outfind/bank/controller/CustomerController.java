package br.com.outfind.bank.controller;

import br.com.outfind.bank.dto.CustomerRequestDTO;
import br.com.outfind.bank.dto.CustomerResponseDTO;
import br.com.outfind.bank.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerResponseDTO> getCustomers() {
        return service.getCustomers();
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO dto) {
        return service.createCustomer(dto);
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }
}