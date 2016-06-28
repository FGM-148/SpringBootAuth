package com.example.bootauth.controller;


import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
