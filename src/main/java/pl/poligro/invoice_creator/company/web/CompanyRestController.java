/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:52
 */

package pl.poligro.invoice_creator.company.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.poligro.invoice_creator.company.domain.Company;
import pl.poligro.invoice_creator.company.infrastructure.CompanyRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyRestController {

    CompanyRepository companyRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }
}
