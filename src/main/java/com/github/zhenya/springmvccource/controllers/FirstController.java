package com.github.zhenya.springmvccource.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        System.out.println("Hello! " + name + " " + surname);
     return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
      return "first/goodBye";
    }
}
