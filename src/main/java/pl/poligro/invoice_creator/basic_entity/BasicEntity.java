/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:15
 */

package pl.poligro.invoice_creator.basic_entity;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(of = "uuid")
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uuid = UUID.randomUUID().toString();

    @CreatedDate
    private LocalDateTime createdAt;

    @Audited
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String createdBy;

    @Audited
    private String updatedBy;

    @Version
    private long version;
}
