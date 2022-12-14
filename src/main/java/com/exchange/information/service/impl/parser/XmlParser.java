package com.exchange.information.service.impl.parser;

import com.exchange.information.exception.ExchangeInfoParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class XmlParser {
    private final XmlMapper xmlMapper;

    public XmlParser() {
        this.xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public SecurityFileModel parseSecurityModel(String fileContent) {
        return (SecurityFileModel) parse(fileContent, SecurityFileModel.class);
    }

    public TradeHistoryFileModel parseTradeHistoryModel(String fileContent) {
        return (TradeHistoryFileModel) parse(fileContent, TradeHistoryFileModel.class);
    }

    private Object parse(String fileContent, Class<?> clazz) {
        try {
            return xmlMapper.readValue(fileContent, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExchangeInfoParseException("Error during parsing xml data into database model", e);
        }
    }
}
