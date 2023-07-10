package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        // System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage (@RequestParam(value = "a", required = false) int a,
                                  @RequestParam(value = "b", required = false) int b,
                                  @RequestParam(value = "action", required = false) String action,
                                  Model model) {
        double answer = 0;
        if ("multiplication".equals(action))
            answer = a * b;
        else if ("addition".equals(action))
            answer = a + b;
        else if ("subtraction".equals(action))
            answer = a - b;
        else if ("division".equals(action))
            answer = a / (double)b;

        model.addAttribute("message", "Answer is " + answer);

        return "first/calculator";
    }
}
