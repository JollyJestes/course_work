package com.example.demo4.controllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/create")
public class AddController {
    @PostMapping("/add")
    public String addConfirmWarehouse(@RequestBody String info) throws JsonProcessingException {
        Warehouse obj = new ObjectMapper().readValue(info, Warehouse.class);
        Database warehouse = new  Database();
        System.out.println(info);
        warehouse.load();


        warehouse.add(new Warehouse(obj.getName(), obj.getFirm(), obj.getPrice(), obj.getAmount(),
                obj.getW(), obj.getDate(), obj.getMinimum_batch()));
        warehouse.save();
        return info;
    }
}