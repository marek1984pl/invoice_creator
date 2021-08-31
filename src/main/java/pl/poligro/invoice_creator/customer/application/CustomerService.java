/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 18:52
 */

package pl.poligro.invoice_creator.customer.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poligro.invoice_creator.customer.application.port.CustomerUseCase;
import pl.poligro.invoice_creator.customer.domain.Customer;
import pl.poligro.invoice_creator.customer.infrastructure.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class CustomerService implements CustomerUseCase {
    CustomerRepository companyRepository;

    @Override
    public List<Customer> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Customer addCompany(CreateCompanyCommand command) {
        Customer customer = command.toCustomer();
        return companyRepository.save(customer);
    }
}
