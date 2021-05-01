package com.baranski.gradlediapplication.controller;

import com.baranski.gradlediapplication.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ItemControllerWithAutowireBySetter {

    public static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithAutowireBySetter.class);
    private ItemService itemService;

    //Injection by method, not really useful but another working option
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event) {
        LOG.info("Autowiring by setter");
        LOG.info(itemService.getClass().getName());

    }

}
