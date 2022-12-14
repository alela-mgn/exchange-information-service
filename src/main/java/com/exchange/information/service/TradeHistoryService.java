package com.exchange.information.service;

import com.exchange.information.dto.DetailedHistory;
import com.exchange.information.model.TradeHistory;

import java.util.List;

public interface TradeHistoryService {
    TradeHistory save(TradeHistory tradeHistory);

    List<TradeHistory> findAll();

    List<TradeHistory> findAllBySecId(String SecId);

    TradeHistory update(String secId, TradeHistory tradeHistory);

    void delete(String id);

    List<DetailedHistory> getDetailedHistory();
}
