/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 18.08.2021
 * Time: 19:12
 */

package pl.poligro.invoice_creator;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.poligro.invoice_creator.customer.application.port.CustomerUseCase;
import pl.poligro.invoice_creator.product.application.port.ProductUseCase;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Profile("dev")
public class ApplicationStartup implements CommandLineRunner {

    CustomerUseCase customerUseCase;
    ProductUseCase productUseCase;

    @Override
    public void run(String... args) throws Exception {
        initCustomers();
        initInvoiceItems();
    }

    private void initInvoiceItems() {
        ProductUseCase.ProductCommand lgOled = ProductUseCase.ProductCommand
                .builder()
                .name("LG 55CX3LA 55 OLED 4K 120Hz WebOS Dolby Atmos HDMI 2.1")
                .shortName("LG 55CX3LA")
                .unit("szt.")
                .grossPrice(new BigDecimal("5000"))
                .vat(new BigDecimal("23"))
                .build();

        ProductUseCase.ProductCommand samsungOled = ProductUseCase.ProductCommand
                .builder()
                .name("Samsung QE65Q70AAT 4K QLED HDR+ Smart TV")
                .shortName("Samsung QE65Q70AAT")
                .unit("szt.")
                .grossPrice(new BigDecimal("4399"))
                .vat(new BigDecimal("23"))
                .build();

        productUseCase.addProduct(lgOled);
        productUseCase.addProduct(samsungOled);
    }

    private void initCustomers() {
        customerUseCase.addCompany(new CustomerUseCase.CreateCompanyCommand("xxx", "yyy", "vat"));
    }
}
