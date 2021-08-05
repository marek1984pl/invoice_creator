/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:10
 */

package pl.poligro.invoice_creator.payment.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Data
@Audited
@MappedSuperclass
@Table(name = "PAYMENT_METHOD", schema = "REF")
public class PaymentMethodEntity {
}
