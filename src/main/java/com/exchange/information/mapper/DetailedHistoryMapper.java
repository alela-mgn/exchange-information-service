package com.exchange.information.mapper;

import com.exchange.information.dto.DetailedHistory;
import com.exchange.information.model.TradeHistory;

public class DetailedHistoryMapper {

    public DetailedHistory toDetailedHistory(TradeHistory history) {
        return DetailedHistory.builder()
                .secid(history.getHistoryId().getSecid())
                .emitentTitle(history.getSecurity().getEmitentTitle())
                .name(history.getSecurity().getName())
                .regnumber(history.getSecurity().getRegnumber())
                .tradeDate(history.getHistoryId().getTradeDate())
                .open(history.getOpen())
                .close(history.getClose()).build();
    }
}
