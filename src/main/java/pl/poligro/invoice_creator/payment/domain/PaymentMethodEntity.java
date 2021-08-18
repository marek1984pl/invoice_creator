/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:10
 */

package pl.poligro.invoice_creator.payment.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.basic_entity.BasicReferenceEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Audited
@Table(name = "PAYMENT_METHOD", schema = "R")
public class PaymentMethodEntity extends BasicReferenceEntity {

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PaymentMethodEntity that = (PaymentMethodEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1730999945;
    }
}
