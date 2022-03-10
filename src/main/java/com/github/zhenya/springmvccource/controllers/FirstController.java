package com.github.zhenya.springmvccource.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String surname, Model model) {

//        System.out.println("Hello! " + name + " " + surname);
        model.addAttribute("message", "Hello! " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodBye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam int a, @RequestParam int b, @RequestParam String action, Model model) {
        double c;
        switch (action) {
            case "multiplication":
                c = a * b;
                break;
            case "addition":
                c = a + b;
                break;
            case "division":
                c = a / (double)b;//для того чтобы при делении получалось вещественное число
                break;
            case "substraction":
                c = a - b;
                break;
            default:
                c = 0;
        }
        model.addAttribute("result", String.valueOf(c));

        return "first/result";
    }
}
