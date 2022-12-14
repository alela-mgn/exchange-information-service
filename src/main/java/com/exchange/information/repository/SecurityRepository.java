package com.exchange.information.repository;

import com.exchange.information.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<Security, String> {
    Optional<Security> findBySecid(String secId);
}
