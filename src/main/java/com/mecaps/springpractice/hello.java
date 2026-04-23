package com.mecaps.springpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Controller
@RequestMapping("/hello")
public  class hello  {
    @GetMapping
    public String hell() {
        return "no";
    }
    @GetMapping("/sum")
    public String ff () {
        int a  = 10;
        int b = 20;
        int sum = a+b;
        return  "sum of two num + sum";
    }
}