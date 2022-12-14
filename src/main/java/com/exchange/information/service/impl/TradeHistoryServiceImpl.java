package com.exchange.information.service.impl;

import com.exchange.information.model.TradeHistory;
import com.exchange.information.repository.TradeHistoryRepository;
import com.exchange.information.service.TradeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private final TradeHistoryRepository tradeHistoryRepository;

    @Transactional
    @Override
    public TradeHistory save(TradeHistory tradeHistory) {
        return tradeHistoryRepository.save(tradeHistory);
    }

}
