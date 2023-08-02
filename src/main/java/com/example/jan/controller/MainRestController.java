package com.example.jan.controller;


import com.example.jan.model.Delegate;
import com.example.jan.service.DelegateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/delegates")
public class MainRestController {

    private final DelegateService delegateService;

    public MainRestController(DelegateService delegateService) {
        this.delegateService = delegateService;
    }


    @GetMapping("/hey")
    public String getHello() {
        return "Hello";
    }

    @GetMapping(value = "/{id}")
    public Delegate getDelegateById(@PathVariable Long id) {
        return delegateService.getDelegateById(id);
    }

    @GetMapping
    public List<Delegate> getAllDelegates() {
        return delegateService.getAllDelegates();
    }

    @PutMapping
    public Delegate createDelegate(@RequestBody Delegate delegate) {
        return delegateService.saveDelegate(delegate);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDelegateById(@PathVariable Long id) {
        delegateService.deleteDelegate(id);
    }

}
