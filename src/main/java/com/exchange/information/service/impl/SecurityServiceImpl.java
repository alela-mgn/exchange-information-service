package com.exchange.information.service.impl;

import com.exchange.information.model.Security;
import com.exchange.information.repository.SecurityRepository;
import com.exchange.information.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityRepository repository;

    @Transactional
    @Override
    public Security save(Security security) {
        return repository.save(security);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Security> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Security findBySecId(String secId) {
        return repository.findBySecid(secId)
                .orElseThrow(() -> new EntityNotFoundException(format("Security was not found with secid=%s", secId)));
    }

    @Transactional
    @Override
    public Security update(String id, Security security) {
        Security foundEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Security was not found with id=%s", id)));
        foundEntity.setRegnumber(security.getRegnumber());
        foundEntity.setName(security.getName());
        foundEntity.setEmitentTitle(security.getEmitentTitle());

        return repository.save(security);
    }

    @Transactional
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
