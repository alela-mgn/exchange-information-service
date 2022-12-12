package com.exchange.information.service.impl;

import com.exchange.information.exception.ExchangeInfoParseException;
import com.exchange.information.model.Security;
import com.exchange.information.service.ParseService;
import com.exchange.information.service.SecurityService;
import com.exchange.information.service.impl.parser.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class ParseServiceImpl implements ParseService {
    private final SecurityService securityService;
    private final XmlParser parser;

    @Override
    public List<Security> parseSecurityXmlFile(MultipartFile file) {
        String fileContent = readFile(file);
        List<Security> securities = parser.parseSecurityModel(fileContent).getData().getRows();

        return Optional.ofNullable(securities)
                .map(list -> list.stream().map(this::persistSecurity).filter(Objects::nonNull).collect(Collectors.toList()))
                .orElse(emptyList());
    }

    private String readFile(MultipartFile file) {
        try {
            return new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ExchangeInfoParseException("Error during retrieving file content", e);
        }
    }

    private Security persistSecurity(Security security) {
        try {
            return securityService.save(security);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
