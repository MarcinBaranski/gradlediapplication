package com.baranski.gradlediapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InfoService {

    public static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

    @Value("${application.alternative.name}")
    String appAlternativeName;

    @Value("${testEnvValue}")
    private String testEnvValue;

    @Value("${applicationValues}")
    private String applicationValues;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("Reading from application.properties using @Value:");
        LOG.info(appAlternativeName);
        LOG.info(testEnvValue);
        Arrays.asList(applicationValues).forEach(LOG::info);
    }
}
