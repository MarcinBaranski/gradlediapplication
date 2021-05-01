package com.baranski.gradlediapplication.controller;

import com.baranski.gradlediapplication.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ItemControllerWithAutowireByField {
    public static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithAutowireByField.class);

    // Object can't be initiated manually with specified initial values. Use case not for tests where we need to set some
    // initial values. Useable when we want to inject many not initialized objects into one place(object)
    @Autowired
    private ItemService itemService;

    public ItemControllerWithAutowireByField(ItemService itemService) {
        this.itemService = itemService;
    }
    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("Autowiring by field");
        LOG.info(itemService.getClass().getName());
    }
}
