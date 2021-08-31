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
import org.springframework.transaction.annotation.Transactional;
import pl.poligro.invoice_creator.customer.application.port.CustomerUseCase;
import pl.poligro.invoice_creator.product.application.port.ProductUseCase;
import pl.poligro.invoice_creator.product.domain.ProductCategory;
import pl.poligro.invoice_creator.product.infrastructure.ProductCategoryRepository;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Profile("dev")
public class ApplicationStartup implements CommandLineRunner {

    CustomerUseCase customerUseCase;
    ProductUseCase productUseCase;
    ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initCustomers();
        initInvoiceItems();
    }

    private void initInvoiceItems() {
        ProductCategory tvCategory = new ProductCategory("TV");
        productCategoryRepository.save(tvCategory);

        ProductUseCase.AddProductCommand lgOled = ProductUseCase.AddProductCommand
                .builder()
                .name("LG 55CX3LA 55 OLED 4K 120Hz WebOS Dolby Atmos HDMI 2.1")
                .shortName("LG 55CX3LA")
                .unit("szt.")
                .grossPrice(new BigDecimal("5000"))
                .vat(new BigDecimal("23"))
                .productCategory(tvCategory)
                .build();

        ProductUseCase.AddProductCommand samsungOled = ProductUseCase.AddProductCommand
                .builder()
                .name("Samsung QE65Q70AAT 4K QLED HDR+ Smart TV")
                .shortName("Samsung QE65Q70AAT")
                .unit("szt.")
                .grossPrice(new BigDecimal("4399"))
                .vat(new BigDecimal("23"))
                .productCategory(tvCategory)
                .build();

        ProductUseCase.AddProductCommand whirlpool = ProductUseCase.AddProductCommand
                .builder()
                .name("WHIRLPOOL FFB 7038 BV PL 7kg 1000 obr")
                .shortName("WHIRLPOOL FFB 7038 BV")
                .unit("szt.")
                .grossPrice(new BigDecimal("1399"))
                .vat(new BigDecimal("23"))
                .build();

        productUseCase.addProduct(lgOled);
        productUseCase.addProduct(samsungOled);
        productUseCase.addProduct(whirlpool);
    }

    private void initCustomers() {
        CustomerUseCase.CreateCustomerCommand customer = CustomerUseCase.CreateCustomerCommand
                .builder()
                .fullName("Example company Ltd.")
                .shortName("Example")
                .vat("EU154241566")
                .build();

        customerUseCase.addCustomer(customer);
    }
}
