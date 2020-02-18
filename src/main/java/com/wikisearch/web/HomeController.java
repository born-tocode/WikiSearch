package com.wikisearch.web;

import com.wikisearch.service.UriService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    @ResponseBody
    @GetMapping("/query/club")
    public String getClubNameFromUser(@RequestParam("name") String name) throws IOException {
        new UriService().run(name);
        return name;
    }
}
