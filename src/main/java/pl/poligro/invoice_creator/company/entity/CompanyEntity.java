/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 20:38
 */

package pl.poligro.invoice_creator.company.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Data
@Entity
@Audited
@EqualsAndHashCode(callSuper = true)
public class CompanyEntity extends CustomerEntity {
    String vatNumber;
}
