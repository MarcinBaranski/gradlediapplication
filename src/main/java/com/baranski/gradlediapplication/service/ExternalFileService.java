package com.baranski.gradlediapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

@Service
public class ExternalFileService {

    public static final Logger LOG = LoggerFactory.getLogger(ExternalFileService.class);

    @Value("file:C:/Users/Marcin/Desktop/resourceSample.txt")
    Resource resourceTestFile;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("Reading non classpath external file injected by @Value:");
        try (Stream<String> stream = Files.lines(resourceTestFile.getFile().toPath())){
            stream.forEach(LOG::info);
        } catch (IOException e) {
            LOG.error(e.getMessage(),e);
        }

    }
}
