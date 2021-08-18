/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 18:52
 */

package pl.poligro.invoice_creator.company.application.port;

import pl.poligro.invoice_creator.company.domain.Company;

import java.util.List;

public interface CustomerUseCase {

    List<Company> findAllCompanies();
}
