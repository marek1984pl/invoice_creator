/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 18:52
 */

package pl.poligro.invoice_creator.company.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poligro.invoice_creator.company.application.port.CustomerUseCase;
import pl.poligro.invoice_creator.company.domain.Company;
import pl.poligro.invoice_creator.company.infrastructure.CompanyRepository;

import java.util.List;

@Service
@AllArgsConstructor
class CustomerService implements CustomerUseCase {
    CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }
}