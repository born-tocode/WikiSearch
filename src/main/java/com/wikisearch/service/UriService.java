package com.wikisearch.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@Service
public class UriService {

    private final Map<String, String> URI_BUILDER;
    private StringBuilder stringBuilder;

    public UriService() {
        URI_BUILDER = Map.of("FirstPart", "https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=",
                             "LastPart", "&srlimit=10");
        this.stringBuilder = new StringBuilder();
    }

    public void run(String clubString) throws IOException {
        var preparedString = addQueryFromUser(clubString);
        var uri = makeUriFromString(preparedString);
        new JsonService().run(uri);
    }

    private URI makeUriFromString(String preparedString) {
        return URI.create(preparedString);
    }

    private String addQueryFromUser(String clubString) {
        if (clubString == null) {
            throw new IllegalArgumentException("Put correct string");
        }
        return stringBuilder
                .append(URI_BUILDER.get("FirstPart"))
                .append(clubString)
                .append(URI_BUILDER.get("LastPart"))
                .toString();
    }
}

