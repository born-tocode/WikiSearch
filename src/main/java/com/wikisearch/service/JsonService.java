package com.wikisearch.service;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wikisearch.WikiPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class JsonService {

    private ObjectMapper objectMapper;
    private RestTemplate restTemplate;
    private Iterable<WikiPage> wikiPages;

    public JsonService() {
        this.objectMapper = new ObjectMapper();
        this.restTemplate = new RestTemplate();
    }

    public void run(URI uri) throws IOException {
        parseJson(uri);
    }

    public void parseJson(URI uri) throws IOException {
        List<WikiPage> wikiPages = new LinkedList<>();
        SimpleModule module = new SimpleModule("JsonCustomDeserializer", new Version(3, 1, 8, null, null, null));
        module.addDeserializer(WikiPage.class, new JsonCustomDeserializer(WikiPage.class));

        objectMapper.registerModule(module);
        objectMapper.readValue(uri.toURL(), WikiPage.class);

    }

}


