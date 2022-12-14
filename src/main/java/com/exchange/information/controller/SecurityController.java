package com.exchange.information.controller;

import com.exchange.information.model.Security;
import com.exchange.information.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityController {
    private final SecurityService service;

    @GetMapping
    public List<Security> getAll() {
        return service.findAll();
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping("/get/{secId}")
    public Security getBySecId(@PathVariable("secId") String secId) {
        return service.findBySecId(secId);
    }

    @PostMapping("/create")
    public Security save(@RequestBody Security security) {
        return service.save(security);
    }

    @PutMapping("/update/{id}")
    public Security update(@PathVariable String id, @RequestBody Security security) {
        return service.update(id, security);
    }
}
