package com.mymovies.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class HomeController {

    @RequestMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getHomePage() {
        return "index.html";
    }

}