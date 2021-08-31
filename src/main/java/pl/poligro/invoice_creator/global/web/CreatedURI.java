/*
 * Copyright 2021 Marek Morawiec
 * User: marek
 * Date: 31.08.2021
 * Time: 18:29
 */

package pl.poligro.invoice_creator.global.web;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.poligro.invoice_creator.basic_entity.BasicEntity;

import java.net.URI;

public class CreatedURI {

    private CreatedURI() {
    }

    public static <T extends BasicEntity> URI get(T entity) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + entity.getId().toString()).build().toUri();
    }
}
