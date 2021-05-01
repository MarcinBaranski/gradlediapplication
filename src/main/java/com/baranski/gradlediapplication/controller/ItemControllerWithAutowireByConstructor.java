package com.baranski.gradlediapplication.controller;

import com.baranski.gradlediapplication.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ItemControllerWithAutowireByConstructor {
    public static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithAutowireByConstructor.class);

    private ItemService itemService;

    @Autowired //Unnecessary option. Bean is Autowired automatically from Spring 4.2.3 version
    public ItemControllerWithAutowireByConstructor(ItemService itemService) {
        this.itemService = itemService;
    }

    @EventListener
    public void onApplicationStart(ApplicationReadyEvent event){
        LOG.info("Autowiring by contructor");
        LOG.info(itemService.getClass().getName());
    }

}
