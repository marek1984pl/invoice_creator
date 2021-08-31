/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 31.08.2021
 * Time: 12:39
 */

package pl.poligro.invoice_creator.product.domain;

import lombok.*;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.basic_entity.BasicReferenceEntity;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ProductCategory extends BasicReferenceEntity {

    @Audited
    private String name;
}
