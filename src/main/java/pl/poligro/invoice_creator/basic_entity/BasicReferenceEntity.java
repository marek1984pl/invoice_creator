/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:14
 */

package pl.poligro.invoice_creator.basic_entity;

import org.hibernate.envers.Audited;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class BasicReferenceEntity extends BasicEntity {

    @Audited
    LocalDateTime expiredAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicReferenceEntity that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(expiredAt, that.expiredAt);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (expiredAt != null ? expiredAt.hashCode() : 0);
        return result;
    }
}
