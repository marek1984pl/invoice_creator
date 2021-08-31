/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:52
 */

package pl.poligro.invoice_creator.customer.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.poligro.invoice_creator.customer.application.port.CustomerUseCase;
import pl.poligro.invoice_creator.customer.domain.Customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CompanyRestController {

    CustomerUseCase customerUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customerUseCase.findAllCompanies();
    }

    @GetMapping("/{id}")
    // TODO: 30.08.2021 responseStatus
    public Optional<Customer> getCompanyById(@PathVariable Long id) {
        // TODO: 28.08.2021 fix this to throw exception
        return customerUseCase.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> addCompany(@RequestBody RestCreateCompanyCommand command) {
        Customer customer = customerUseCase.addCompany(command.toCreateCompanyCommand());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + customer.getId().toString()).build().toUri();
        return ResponseEntity.created(uri).build();
    }

    @Data
    private static class RestCreateCompanyCommand {

        private String fullName;
        private String shortName;
        private String vatNumber;

        public CustomerUseCase.CreateCompanyCommand toCreateCompanyCommand() {
            return new CustomerUseCase.CreateCompanyCommand(fullName, shortName, vatNumber);
        }
    }
}
