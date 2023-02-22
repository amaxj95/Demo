package com.nikedemo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {

        @GetMapping("/greet")
        public String greetings(){
            return "Welcome to the Demo Metrics App and Server";
        }
}