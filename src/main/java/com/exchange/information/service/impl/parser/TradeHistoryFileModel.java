package com.exchange.information.service.impl.parser;

import com.exchange.information.model.TradeHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TradeHistoryFileModel {
    Data<TradeHistory> data;
}
