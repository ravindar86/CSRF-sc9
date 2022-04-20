package com.example.csrfsc9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping
    public String main(){
        return "main.html";
    }

    @PostMapping("/change")
    public String add(){
        System.out.println("Inside add.. ");
        return "main.html";
    }

    @PostMapping("/csrfdisabled")
    public String csrfdisabled(){
        System.out.println("Inside csrfdisabled.. ");
        return "main.html";
    }

   /* @PostMapping("/change") // POST, PUT, DELETE mutating actions in REST
    public String doSmth() {
        System.out.println(":(");
        return "main.html";
    } */

}
