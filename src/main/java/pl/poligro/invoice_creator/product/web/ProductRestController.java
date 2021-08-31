/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:36
 */

package pl.poligro.invoice_creator.product.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.poligro.invoice_creator.product.application.port.ProductUseCase;
import pl.poligro.invoice_creator.product.domain.Product;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductRestController {

    private final ProductUseCase productUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productUseCase.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productUseCase.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

