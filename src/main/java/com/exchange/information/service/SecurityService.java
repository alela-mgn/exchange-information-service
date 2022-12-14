package com.exchange.information.service;

import com.exchange.information.model.Security;

import java.util.List;

public interface SecurityService {
    Security save(Security security);

    List<Security> findAll();

    Security findBySecId(String secId);

    Security update(String id, Security security);

    void delete(String id);
}
