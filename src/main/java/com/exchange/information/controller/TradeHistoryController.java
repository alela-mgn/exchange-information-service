package com.exchange.information.controller;

import com.exchange.information.model.TradeHistory;
import com.exchange.information.service.TradeHistoryService;
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
@RequestMapping("/api/histories")
@RequiredArgsConstructor
public class TradeHistoryController {
    private final TradeHistoryService service;

    @GetMapping
    public List<TradeHistory> getAll() {
        return service.findAll();
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping("/get/{id}")
    public List<TradeHistory> getById(@PathVariable("id") String id) {
        return service.findAllBySecId(id);
    }

    @PostMapping("/create")
    public TradeHistory save(@RequestBody TradeHistory security) {
        return service.save(security);
    }

    @PutMapping("/update/{secId}")
    public TradeHistory update(@PathVariable String secId, @RequestBody TradeHistory history) {
        return service.update(secId, history);
    }
}
