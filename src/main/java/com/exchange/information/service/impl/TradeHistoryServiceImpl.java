package com.exchange.information.service.impl;

import com.exchange.information.dto.DetailedHistory;
import com.exchange.information.mapper.DetailedHistoryMapper;
import com.exchange.information.model.TradeHistory;
import com.exchange.information.repository.TradeHistoryRepository;
import com.exchange.information.service.TradeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private final TradeHistoryRepository repository;

    @Transactional
    @Override
    public TradeHistory save(TradeHistory tradeHistory) {
        return repository.save(tradeHistory);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TradeHistory> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TradeHistory> findAllBySecId(String id) {
        return repository.findAllByHistoryId_Secid(id);
    }

    @Transactional
    @Override
    public TradeHistory update(String id, TradeHistory history) {
        TradeHistory tradeHistory = repository.findByHistoryId_SecidAndHistoryId_TradeDate(id, history.getHistoryId().getTradeDate())
                .orElseThrow(() -> new EntityNotFoundException(format("TradeHistory was not found with id=%s", id)));

        tradeHistory.setNumtrades(history.getNumtrades());
        tradeHistory.setOpen(history.getOpen());
        tradeHistory.setClose(history.getClose());

        return repository.save(history);
    }

    @Transactional
    @Override
    public void delete(String id) {
        repository.deleteAll(repository.findAllByHistoryId_Secid(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetailedHistory> getDetailedHistory() {
        DetailedHistoryMapper mapper = new DetailedHistoryMapper();
        List<TradeHistory> tradeHistoryList = repository.findAll();

        return tradeHistoryList.stream().map(mapper::toDetailedHistory).collect(Collectors.toList());
    }
}
