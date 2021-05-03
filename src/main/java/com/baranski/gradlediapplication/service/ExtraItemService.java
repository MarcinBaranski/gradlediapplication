package com.baranski.gradlediapplication.service;

import com.baranski.gradlediapplication.configuration.NonSpringComponentByName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ExtraItemService {
    public static final Logger LOG = LoggerFactory.getLogger(ExtraItemService.class);

    private NonSpringComponentByName nonSpringComponentByName;

    public ExtraItemService(@Qualifier("nonSpringBean") NonSpringComponentByName nonSpringComponentByName) {
        this.nonSpringComponentByName = nonSpringComponentByName;
    }

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("ExtraItemService!");
        LOG.info(nonSpringComponentByName.getClass().getName());
    }
}
