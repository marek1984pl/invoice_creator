/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 30.08.2021
 * Time: 18:25
 */

package pl.poligro.invoice_creator.product.domain;

import lombok.*;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.basic_entity.BasicBusinessEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "b")
public class Product extends BasicBusinessEntity {

    @Audited
    private String name;

    @Audited
    private String shortName;

    @Audited
    private String unit;

    @Audited
    private BigDecimal grossPrice;

    @Audited
    private BigDecimal vat;

    @Audited
    private boolean service;

    @Audited
    @OneToOne
    private ProductCategory productCategory;

    public BigDecimal getNetPrice() {
        return grossPrice.divide(getVatPercent().add(BigDecimal.ONE), RoundingMode.HALF_DOWN);
    }

    public BigDecimal getVatAmount() {
        return (grossPrice.multiply(getVatPercent()).divide(vat, RoundingMode.HALF_DOWN));
    }

    private BigDecimal getVatPercent() {
        return vat.divide(new BigDecimal("100"), RoundingMode.HALF_DOWN);
    }
}
