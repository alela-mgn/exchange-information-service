package com.exchange.information.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "securities")
@RequiredArgsConstructor
@Getter
public class Security {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 51, name = "secid")
    private String secid;

    @Column(nullable = false, length = 189, name = "regnumber")
    private String regnumber;

    @Column(nullable = false, length = 765, name = "name")
    private String name;

    @Column(nullable = false, length = 765, name = "emitent_title")
    @JsonProperty("emitent_title")
    private String emitentTitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(secid, security.secid) && Objects.equals(regnumber, security.regnumber) && Objects.equals(name, security.name) && Objects.equals(emitentTitle, security.emitentTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secid, regnumber, name, emitentTitle);
    }
}
