/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 31.08.2021
 * Time: 12:51
 */

package pl.poligro.invoice_creator.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poligro.invoice_creator.product.domain.ProductCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findOneByNameIgnoreCase(String name);
}
