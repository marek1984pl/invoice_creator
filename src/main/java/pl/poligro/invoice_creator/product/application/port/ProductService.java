/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:36
 */

package pl.poligro.invoice_creator.product.application.port;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poligro.invoice_creator.product.domain.Product;
import pl.poligro.invoice_creator.product.domain.ProductCategory;
import pl.poligro.invoice_creator.product.infrastructure.ProductCategoryRepository;
import pl.poligro.invoice_creator.product.infrastructure.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public Optional<Product> getById(Long invoiceId) {
        return productRepository.findById(invoiceId);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByProductCategory(ProductCategory productCategory) {
        return productRepository.findByProductCategory_nameIgnoreCase(productCategory.getName());
    }

    public Optional<ProductCategory> getProductCategoryByName(String name) {
        return productCategoryRepository.findOneByNameIgnoreCase(name);
    }

    @Override
    public Product addProduct(ProductCommand command) {
        Product product = Product
                .builder()
                .name(command.getName())
                .shortName(command.getShortName())
                .unit(command.getUnit())
                .grossPrice(command.getGrossPrice())
                .vat(command.getVat())
                .service(command.isService())
                .productCategory(command.getProductCategory())
                .build();

        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }
}
