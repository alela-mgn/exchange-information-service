package com.exchange.information.controller;

import com.exchange.information.model.Security;
import com.exchange.information.model.TradeHistory;
import com.exchange.information.service.ImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/import/")
@RequiredArgsConstructor
public class ImportController {
    private final ImportService service;

    @PostMapping("securities")
    public List<Security> importSecurities(@RequestParam("file") MultipartFile file) {
        return service.parseSecurityXmlFile(file);
    }

    @PostMapping("histories")
    public List<TradeHistory> importTradeHistory(@RequestParam("file") MultipartFile file) {
        return service.parseTradeHistoryXmlFile(file);
    }
}
