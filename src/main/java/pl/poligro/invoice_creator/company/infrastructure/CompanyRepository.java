/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 05.08.2021
 * Time: 18:45
 */

package pl.poligro.invoice_creator.company.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.poligro.invoice_creator.company.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
