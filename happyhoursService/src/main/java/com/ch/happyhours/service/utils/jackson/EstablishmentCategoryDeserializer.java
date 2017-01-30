package com.ch.happyhours.service.utils.jackson;

import com.ch.happyhours.service.domain.EstablishmentCategory;
import com.ch.happyhours.service.domain.Sex;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Chemakh on 30/01/2017.
 */
public class EstablishmentCategoryDeserializer extends JsonDeserializer<EstablishmentCategory> {

    @Override
    public EstablishmentCategory deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException
    {
        return EstablishmentCategory.fromString(jsonParser.getText().toUpperCase());
    }
}
