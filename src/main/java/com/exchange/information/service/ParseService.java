package com.exchange.information.service;

import com.exchange.information.model.Security;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ParseService {

    List<Security> parseSecurityXmlFile(MultipartFile file);
}
