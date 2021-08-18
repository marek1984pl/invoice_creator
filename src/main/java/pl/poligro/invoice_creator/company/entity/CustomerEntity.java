/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:46
 */

package pl.poligro.invoice_creator.company.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.basic_entity.BasicBusinessEntity;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public abstract class CustomerEntity extends BasicBusinessEntity {

    @Audited
    private String fullName;

    @Audited
    private String shortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CustomerEntity that = (CustomerEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1984353346;
    }
}

