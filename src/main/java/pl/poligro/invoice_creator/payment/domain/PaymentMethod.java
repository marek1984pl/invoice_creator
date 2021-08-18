/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 04.08.2021
 * Time: 21:08
 */

package pl.poligro.invoice_creator.payment.domain;

public enum PaymentMethod {
    CASH,
    WIRE_TRANSFER,
    PAYPAL,
    CREDIT_CARD,
    BLIK,
    OTHER
}
