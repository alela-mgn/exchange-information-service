package com.exchange.information.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedHistory {
    private String secid;
    private String regnumber;
    private String name;
    private String emitentTitle;
    private LocalDate tradeDate;
    private Double open;
    private Double close;

}
