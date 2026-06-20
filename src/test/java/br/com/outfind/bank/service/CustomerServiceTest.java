package br.com.outfind.bank.service;
import br.com.outfind.bank.dto.CustomerRequestDTO;
import br.com.outfind.bank.exception.CustomerCpfAlreadyExistsException;
import br.com.outfind.bank.dto.CustomerResponseDTO;
import br.com.outfind.bank.entity.Customer;
import br.com.outfind.bank.exception.CustomerNotFoundException;
import br.com.outfind.bank.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void shouldReturnCustomerWhenIdExists() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFullName("Gilvan Menezes");
        customer.setEmail("gilvan@email.com");

        when(repository.findById(1L))
                .thenReturn(Optional.of(customer));

        CustomerResponseDTO response =
                service.getCustomerById(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Gilvan Menezes", response.getFullName());
        assertEquals("gilvan@email.com", response.getEmail());
    }

    @Test
    void shouldThrowExceptionWhenCustomerDoesNotExist() {

        when(repository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                CustomerNotFoundException.class,
                () -> service.getCustomerById(999L)
        );
    }
    @Test
    void shouldThrowExceptionWhenCpfAlreadyExists() {

        // Arrange

        CustomerRequestDTO dto = new CustomerRequestDTO();
        dto.setFullName("Gilvan Menezes");
        dto.setCpf("12345678900");
        dto.setEmail("gilvan@email.com");
        dto.setPhone("13999999999");

        Customer customer = new Customer();
        customer.setCpf("12345678900");

        when(repository.findByCpf("12345678900"))
                .thenReturn(Optional.of(customer));

        // Act + Assert

        assertThrows(
                CustomerCpfAlreadyExistsException.class,
                () -> service.createCustomer(dto)
        );
        }

    @Test
    void shouldCreateCustomer() {

        CustomerRequestDTO dto = new CustomerRequestDTO();
        dto.setFullName("Gilvan Menezes");
        dto.setCpf("12345678900");
        dto.setEmail("gilvan@email.com");
        dto.setPhone("13999999999");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFullName("Gilvan Menezes");
        customer.setCpf("12345678900");
        customer.setEmail("gilvan@email.com");
        customer.setPhone("13999999999");

        when(repository.findByCpf("12345678900"))
                .thenReturn(Optional.empty());

        when(repository.save(any(Customer.class)))
                .thenReturn(customer);

        CustomerResponseDTO response =
                service.createCustomer(dto);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Gilvan Menezes", response.getFullName());
        assertEquals("gilvan@email.com", response.getEmail());

        verify(repository).save(any(Customer.class));
    }
    }
