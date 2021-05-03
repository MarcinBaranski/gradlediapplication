package com.baranski.gradlediapplication.service;

import com.baranski.gradlediapplication.configuration.NonSpringComponentByMultipleNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ExtraItemServiceMultipleNames {

    public static final Logger LOG = LoggerFactory.getLogger(ExtraItemServiceMultipleNames.class);

    private NonSpringComponentByMultipleNames nonSpringComponentByMultipleNames;

    public ExtraItemServiceMultipleNames(@Qualifier("secondNonSpringBean") NonSpringComponentByMultipleNames nonSpringComponentByMultipleNames) {
        this.nonSpringComponentByMultipleNames = nonSpringComponentByMultipleNames;
    }
    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("ExtraItemServiceMultipleNames!");
        LOG.info(nonSpringComponentByMultipleNames.getClass().getName());
    }
}
