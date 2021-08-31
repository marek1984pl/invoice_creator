/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:46
 */

package pl.poligro.invoice_creator.customer.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.basic_entity.BasicBusinessEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(schema = "b")
@Builder
@AllArgsConstructor
public class Customer extends BasicBusinessEntity {

    @Audited
    private String fullName;

    @Audited
    private String shortName;

    @Audited
    private String vatNumber;

    @Audited
    private boolean commercialCustomer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer that = (Customer) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1984353346;
    }
}

