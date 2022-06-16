package com.example.demo4.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ListController {
    @GetMapping(value = "/list")
    public String searchClient(Model model) throws IOException {
        model.addAttribute("list", Database.getStringDatabase());
        return "list";
    }
}