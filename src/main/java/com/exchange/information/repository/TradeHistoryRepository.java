package com.exchange.information.repository;

import com.exchange.information.model.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryRepository extends JpaRepository<TradeHistory, String> {
}
