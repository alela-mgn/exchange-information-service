package com.exchange.information.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "histories")
@RequiredArgsConstructor
@Getter
@Setter
public class TradeHistory {
    @EmbeddedId
    @JsonUnwrapped
    private TradeHistoryId historyId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secid", insertable = false, updatable = false)
    @JsonIgnore
    private Security security;

    @Column(name = "numtrades", nullable = false)
    @JsonProperty("NUMTRADES")
    private Double numtrades;

    @Column(name = "open")
    @JsonProperty("OPEN")
    private Double open;

    @Column(name = "close")
    @JsonProperty("CLOSE")
    private Double close;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    public static class TradeHistoryId implements Serializable {
        @Column(name = "secid", length = 36, insertable = false, updatable = false)
        @JsonProperty("SECID")
        private String secid;

        @Column(name = "trade_date", nullable = false)
        @JsonProperty("TRADEDATE")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        private LocalDate tradeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeHistory that = (TradeHistory) o;
        return Objects.equals(security, that.security)
                && Objects.equals(historyId.tradeDate, that.historyId.tradeDate)
                && Objects.equals(numtrades, that.numtrades) && Objects.equals(open, that.open)
                && Objects.equals(close, that.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(security, historyId.tradeDate, numtrades, open, close);
    }
}
