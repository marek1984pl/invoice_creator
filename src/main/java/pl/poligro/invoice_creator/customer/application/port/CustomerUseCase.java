/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 18:52
 */

package pl.poligro.invoice_creator.customer.application.port;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import pl.poligro.invoice_creator.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerUseCase {

    List<Customer> findAllCompanies();

    Optional<Customer> findById(Long id);

    Customer addCustomer(CreateCustomerCommand command);

    @Value
    @Builder
    @AllArgsConstructor
    class CreateCustomerCommand {
        String fullName;
        String shortName;
        String vat;

        public Customer toCustomer() {
            return Customer
                    .builder()
                    .fullName(fullName)
                    .shortName(shortName)
                    .vatNumber(vat)
                    .build();
        }
    }
}
