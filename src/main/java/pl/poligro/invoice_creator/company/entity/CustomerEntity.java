/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:46
 */

package pl.poligro.invoice_creator.company.entity;

import lombok.Data;
import org.hibernate.envers.Audited;
import pl.poligro.invoice_creator.entity.BasicBusinessEntity;

import javax.persistence.*;

@Data
@Audited
@MappedSuperclass
@Table(name = "", schema = "")
public class CustomerEntity extends BasicBusinessEntity {
    private String fullName;

    private String shortName;
}

