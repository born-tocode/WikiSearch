package com.wikisearch.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class UrlService {

    public URL run(String clubString) throws IOException {
        var preparedString = addQueryFromUser(clubString);
        var url = makeUrlFromString(preparedString);
       return new JsonService().run(url);
    }

    private URL makeUrlFromString(String preparedString) throws MalformedURLException {
        return new URL(preparedString);
    }

    private String addQueryFromUser(String clubString) {
        if (clubString == null || clubString.isEmpty() || clubString.isBlank()) {
            throw new IllegalArgumentException("Put any string");
        }

        Map<String, String> urlBuilder = Map.of("FirstPart",
                                                "https://en.wikipedia.org/w/api.php?action=query&generator=search&gsrsearch=",
                                                "LastPart", "&format=json&gsrprop=snippet&prop=info&inprop=url");

        return new StringBuilder()
                .append(urlBuilder.get("FirstPart"))
                .append(clubString)
                .append(urlBuilder.get("LastPart")).toString();
    }

    URL selectUrlByCriteria(List<JsonNode> jsonNodesUrls) throws MalformedURLException {
        URL result;
        List<String> constraints = List.of("C.F.","F.C.","CF","FC");


        jsonNodesUrls.removeIf(jnode -> {
            String url = jnode.asText();
            return !(
                    url.contains(constraints.get(0))
                    || url.contains(constraints.get(1))
                    || url.contains(constraints.get(2))
                    || url.contains(constraints.get(3))
            );
        });

        result = new URL(jsonNodesUrls.get(0).asText());

        return result;
    }
}

