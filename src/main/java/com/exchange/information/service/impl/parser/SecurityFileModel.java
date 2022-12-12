package com.exchange.information.service.impl.parser;

import com.exchange.information.model.Security;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SecurityFileModel {
    Data<Security> data;
}
