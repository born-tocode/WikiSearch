package com.wikisearch.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class JsonService {

    private final UrlService urlService;
    private ObjectMapper objectMapper;

    public JsonService() {
        this.objectMapper = new ObjectMapper();
        urlService = new UrlService();
    }

    public URL run(URL url) throws IOException {
        var jNodeUrl = parseJson(url);
        return urlService.selectUrlByCriteria(jNodeUrl);
    }

    public List<JsonNode> parseJson(URL url) throws IOException {
        JsonNode jNode = objectMapper.readTree(url);
        List<JsonNode> jNodeUrl = jNode.findValues("canonicalurl");

        return jNodeUrl;
    }
}


