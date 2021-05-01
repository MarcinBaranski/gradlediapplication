package com.baranski.gradlediapplication.inject;

import com.baranski.gradlediapplication.service.PrinterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
public class ItemControllerWithIncjectByName {
    public static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithIncjectByName.class);

    //Injecting component by @Inject (annotation from Java EE not Spring framework). We inject component by it's name, but we
    //must use another annotation @Named to specify name of component. Also, we need to add extra javax.inject dependency
    //to project. It is another option, but increase complication level of project.
    @Inject
    @Named("itemServicePrinterable")
    private PrinterService printerService;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("Injecting with @Inject by name:");
        LOG.info(printerService.getClass().getName());
    }
}
