package com.exchange.information.service.impl.parser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data<T> {
    List<T> rows;
}
