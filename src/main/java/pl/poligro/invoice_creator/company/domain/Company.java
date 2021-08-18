/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:38
 */

package pl.poligro.invoice_creator.company.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "COMPANY_CUSTOMER", schema = "B")
public class Company extends Customer {

    @Audited
    private String vatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company that = (Company) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1432171534;
    }
}
