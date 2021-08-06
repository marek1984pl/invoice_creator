/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:14
 */

package pl.poligro.invoice_creator.basic_entity;

import org.hibernate.envers.Audited;

import javax.persistence.MappedSuperclass;

@Audited
@MappedSuperclass
public abstract class BasicReferenceEntity extends BasicEntity {
}
