package com.exchange.information.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "histories")
@RequiredArgsConstructor
@Getter
@Setter
public class TradeHistory {

    @Id
    @Column(name = "secid", length = 36, insertable = false, updatable = false)
    private String secid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "secid",insertable = false, updatable = false)
    @JsonIgnore
    private Security security;

    @Column(name = "trade_date", nullable = false)
    private LocalDate tradeDate;

    @Column(name = "numtrades", nullable = false)
    private Double numtrades;

    @Column(name = "open", nullable = false)
    private Double open;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeHistory history = (TradeHistory) o;
        return Objects.equals(secid, history.secid) && Objects.equals(tradeDate, history.tradeDate) && Objects.equals(numtrades, history.numtrades) && Objects.equals(open, history.open);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secid, tradeDate, numtrades, open);
    }
}
