/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 18:52
 */

package pl.poligro.invoice_creator.customer.application.port;

import lombok.Value;
import pl.poligro.invoice_creator.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerUseCase {

    List<Customer> findAllCompanies();

    Optional<Customer> findById(Long id);

    Customer addCompany(CreateCompanyCommand command);

    @Value
    class CreateCompanyCommand {
        String fullName;
        String shortName;
        String vat;

        public Customer toCustomer() {
            return new Customer();
        }
    }
}
