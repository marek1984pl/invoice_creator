/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:35
 */

package pl.poligro.invoice_creator.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.poligro.invoice_creator.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
