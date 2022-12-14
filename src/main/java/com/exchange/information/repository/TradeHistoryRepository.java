package com.exchange.information.repository;

import com.exchange.information.model.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TradeHistoryRepository extends JpaRepository<TradeHistory, String> {
    List<TradeHistory> findAllByHistoryId_Secid(String secId);

    Optional<TradeHistory> findByHistoryId_SecidAndHistoryId_TradeDate(String secId, LocalDate tradeDate);
}
