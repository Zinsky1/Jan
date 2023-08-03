package com.example.jan.controller;


import com.example.jan.model.Delegate;
import com.example.jan.service.DelegateService;
import com.example.jan.unit.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/delegates")
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
    public ResponseEntity<Delegate> getDelegateById(@PathVariable Long id) {
        Delegate delegate = delegateService.getDelegateById(id);
        if (delegate == null) {
            log.error("get by id: Delegate with id={} not found", id);
            return ResponseEntity.notFound().build();
        }
        log.info("get by id: Delegate with id={} found", id);
        return new ResponseEntity<>(delegate, HttpStatus.OK);
    }

    @GetMapping //мб добавить Pageable
    public ResponseEntity<List<Delegate>> getAllDelegates() {
        log.info("get all: get all Delegates");
        return  new ResponseEntity<>(delegateService.getAllDelegates(), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Delegate> createDelegate(@RequestBody Delegate delegate) {
        log.info("create: new Delegate saved");
        return new ResponseEntity<>(delegateService.saveDelegate(delegate), HttpStatus.OK);
    }


    @PutMapping("/{isNowActive}/{type}")
    ResponseEntity<Delegate> createDelegate(@RequestBody Delegate delegate,
                                            @PathVariable(required = false) Boolean isNowActive,
                                            @PathVariable(required = false) Type type) {
        log.info("create: new Delegate saved");
        return new ResponseEntity<>(delegateService.saveDelegate(delegate, isNowActive, type), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delegate> updateDelegate(@PathVariable Long id, @RequestBody Delegate delegateToUpdate) {
        if (delegateService.getDelegateById(id) == null) {
            log.error("update: delegate with id={} not found", id);
            return ResponseEntity.notFound().build();
        }
        log.info("update: the Delegate with id={} updated", id);
        return ResponseEntity.ok(delegateService.updateDelegate(id, delegateToUpdate));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteDelegateById(@PathVariable Long id) {
        if (delegateService.getDelegateById(id) == null) {
            log.error("delete: delegate with id={} not found", id);
            return ResponseEntity.notFound().build();
        }
        log.info("delete: the Delegate with id={} deleted", id);
        delegateService.deleteDelegate(id);
        return ResponseEntity.ok().build();
    }

}
