/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:15
 */

package pl.poligro.invoice_creator.basic_entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public abstract class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime createdAt;

    @Audited
    private LocalDateTime updatedAt;

    private String createdBy;

    @Audited
    private String updatedBy;

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BasicEntity that = (BasicEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 236437056;
    }
}
