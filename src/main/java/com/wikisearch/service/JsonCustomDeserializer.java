package com.wikisearch.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.wikisearch.WikiPage;

import java.io.IOException;

public class JsonCustomDeserializer extends StdDeserializer<WikiPage> {

    public JsonCustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WikiPage deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        WikiPage wikiPage = new WikiPage();

        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();

                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                if ("title".equals(fieldName)) {
                    wikiPage.setTitle(parser.getValueAsString());
                }
                if ("pageid".equals(fieldName)) {
                    wikiPage.setPageid(parser.getValueAsInt());
                }
                if ("snippet".equals(fieldName)) {
                    wikiPage.setSnippet(parser.getValueAsString());
                }
            }
        }
        return wikiPage;
    }
}
