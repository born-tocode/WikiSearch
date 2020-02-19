package com.wikisearch.web;

import com.wikisearch.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {


    private final UrlService urlService;

    public HomeController(UrlService urlService) {
    this.urlService = urlService;
    }

    @ResponseBody
    @GetMapping("/query/club")
    public String getClubNameFromUser(@RequestParam("name") String clubName) throws IOException {
        var clubUrl = urlService.run(clubName);
        return "Your query: " + clubName
                + "\nRequested URL: " + clubUrl;
    }
}
