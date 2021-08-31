/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 05.08.2021
 * Time: 18:45
 */

package pl.poligro.invoice_creator.customer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.poligro.invoice_creator.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
