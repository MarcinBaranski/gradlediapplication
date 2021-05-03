package com.baranski.gradlediapplication.resource;

import com.baranski.gradlediapplication.service.PrinterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ItemControllerWithReourceByName {

    public static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithReourceByName.class);

    //Injection by @Resource qualifier. We inject component by it's name, but we don't need,second qualifier like
    //in @Qualifier option. We simply from  @Autowired and @Qualifier("component name") to @Resource(name="component name")
    @Resource(name = "itemServicePrinterable")
    private PrinterService printerService;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event) {
        LOG.info("Injecting with Resource by name:");
        LOG.info(printerService.getClass().getName());
    }

}
