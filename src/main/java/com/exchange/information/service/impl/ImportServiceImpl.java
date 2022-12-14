package com.exchange.information.service.impl;

import com.exchange.information.exception.ExchangeInfoParseException;
import com.exchange.information.model.Security;
import com.exchange.information.model.TradeHistory;
import com.exchange.information.service.ImportService;
import com.exchange.information.service.SecurityService;
import com.exchange.information.service.TradeHistoryService;
import com.exchange.information.service.impl.parser.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {
    private final SecurityService securityService;
    private final TradeHistoryService historyService;
    private final XmlParser parser;

    @Override
    public List<Security> parseSecurityXmlFile(MultipartFile file) {
        String fileContent = retrieveFileContent(file);
        List<Security> securities = parser.parseSecurityModel(fileContent).getData().getRows();

        return Optional.ofNullable(securities)
                .map(list -> list.stream().map(e -> persist(e, securityService::save))
                        .filter(Objects::nonNull).collect(Collectors.toList()))
                .orElse(emptyList());
    }

    @Override
    public List<TradeHistory> parseTradeHistoryXmlFile(MultipartFile file) {
        String fileContent = retrieveFileContent(file);
        List<TradeHistory> tradeHistories = parser.parseTradeHistoryModel(fileContent).getData().getRows();

        return Optional.ofNullable(tradeHistories)
                .map(list -> list.stream().map(e -> persist(e, historyService::save))
                        .filter(Objects::nonNull).collect(Collectors.toList()))
                .orElse(emptyList());
    }


    private String retrieveFileContent(MultipartFile file) {
        try {
            return new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ExchangeInfoParseException("Error during retrieving file content", e);
        }
    }

    private <T> T persist(T entity, Function<T, T> persistFunc) {
        try {
            return persistFunc.apply(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
