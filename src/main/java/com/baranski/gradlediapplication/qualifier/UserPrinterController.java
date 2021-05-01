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
public class UserPrinterController {

    public static final Logger LOG = LoggerFactory.getLogger(UserPrinterController.class);

    //Autowiring service described generally by PrinterService interface. But we specified our desired Serviec(UserService)
    //by @Qualifier annotation with "userServicePrinterable" value setted in UserService Class.
    @Autowired
    @Qualifier("userServicePrinterable")
    private PrinterService printerService;

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event){
        LOG.info("============================ userServicePrinterable ============================");
        LOG.info(UserPrinterController.class.getName());
        printerService.printName();
        LOG.info("============================");
    }

}
