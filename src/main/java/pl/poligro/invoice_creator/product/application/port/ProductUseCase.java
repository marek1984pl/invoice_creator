/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:35
 */

package pl.poligro.invoice_creator.product.application.port;

import lombok.Builder;
import lombok.Data;
import pl.poligro.invoice_creator.product.domain.Product;
import pl.poligro.invoice_creator.product.domain.ProductCategory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

    Optional<Product> getById(Long invoiceId);

    List<Product> getAll();

    Optional<ProductCategory> getProductCategoryByName(String name);

    List<Product> getAllProductsByProductCategory(ProductCategory productCategory);

    Product addProduct(ProductCommand command);

    List<Product> getProductsByName(String name);

    @Data
    @Builder
    class ProductCommand {

        String name;

        String shortName;

        String unit;

        BigDecimal grossPrice;

        BigDecimal vat;

        @Builder.Default
        boolean service = false;

        ProductCategory productCategory;
    }
}
