package com.baranski.gradlediapplication.qualifier;

import com.baranski.gradlediapplication.service.PrinterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ItemPrinterController {
    public static final Logger LOG = LoggerFactory.getLogger(ItemPrinterController.class);

    //Autowiring service described generally by PrinterService interface. But we specified our desired Serviec(ItemService)
    //by @Qualifier annotation with "itemServicePrinterable" value setted in ItemService Class.
    @Autowired
    @Qualifier("itemServicePrinterable")
    private PrinterService printerService;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event) {
        LOG.info("============================ itemServicePrinterable ============================");
        LOG.info(ItemPrinterController.class.getName());
        printerService.printName();
        //LOG.info("============================");
    }


}
