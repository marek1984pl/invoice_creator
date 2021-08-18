/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:55
 */

package pl.poligro.invoice_creator.company.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Audited
@Table(name = "PRIVATE_CUSTOMER", schema = "B")
public class PrivateCustomerEntity extends CustomerEntity {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrivateCustomerEntity that = (PrivateCustomerEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 2138336056;
    }
}
