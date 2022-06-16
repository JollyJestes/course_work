package com.example.demo4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateController {
@GetMapping("/create")
    public String createMain(Model model){
    return "create-main";
}
}
