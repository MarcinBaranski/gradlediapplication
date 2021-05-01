package com.baranski.gradlediapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userServicePrinterable")
public class UserService implements PrinterService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Override
    public void printName() {
        LOG.info("UserService");
    }
}
