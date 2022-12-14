package com.exchange.information.service;

import com.exchange.information.model.Security;
import com.exchange.information.model.TradeHistory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImportService {

    List<Security> parseSecurityXmlFile(MultipartFile file);

    List<TradeHistory> parseTradeHistoryXmlFile(MultipartFile file);
}
