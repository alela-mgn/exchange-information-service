package com.exchange.information.service.impl;

import com.exchange.information.model.Security;
import com.exchange.information.repository.SecurityRepository;
import com.exchange.information.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityRepository securityRepository;

    @Transactional
    @Override
    public Security save(Security security) {
        return securityRepository.save(security);
    }
}
