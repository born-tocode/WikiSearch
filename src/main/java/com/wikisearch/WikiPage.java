package com.wikisearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPage {

    Integer ns = 0;
    String title = "";
    Integer pageid = 0;
    Long size = 0L;
    Long wordcount = 0L;
    String snippet = "";
    Timestamp timestamp = Timestamp.from(Instant.now());

}
