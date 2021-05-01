package com.baranski.gradlediapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("itemServicePrinterable")
public class ItemService implements PrinterService {

    private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);

    @Override
    public void printName() {
        LOG.info("ItemService");
        //LOG.info("============================");
        //LOG.info();
    }
}
