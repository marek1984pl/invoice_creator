/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:36
 */

package pl.poligro.invoice_creator.product.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poligro.invoice_creator.product.application.port.ProductUseCase;
import pl.poligro.invoice_creator.product.domain.Product;
import pl.poligro.invoice_creator.product.domain.ProductCategory;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductRestController {

    private final ProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam Optional<String> category, @RequestParam Optional<String> name) {
        if (category.isPresent()) {
            Optional<ProductCategory> productCategory = productUseCase.getProductCategoryByName(category.get());
            return productCategory
                    .map(x -> ResponseEntity.ok(productUseCase.getAllProductsByProductCategory(x)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else if (name.isPresent()) {
            List<Product> productByName = productUseCase.getProductsByName(name.get());
            if (productByName.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(productByName);
            }
        }
        return ResponseEntity.ok(productUseCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productUseCase.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

