package com.ch.happyhours.service.utils.jackson;

import com.ch.happyhours.service.domain.ManagerFct;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Chemakh on 30/01/2017.
 */
public class ManagerFctDeserializer extends JsonDeserializer<ManagerFct> {

        @Override
        public ManagerFct deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException
        {
            return ManagerFct.fromString(jsonParser.getText().toUpperCase());
        }

}
