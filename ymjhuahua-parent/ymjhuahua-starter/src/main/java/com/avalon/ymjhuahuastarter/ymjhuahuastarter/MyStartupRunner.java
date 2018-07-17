package com.avalon.ymjhuahuastarter.ymjhuahuastarter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;

public class MyStartupRunner implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void run(String... args) {
        try {
            logger.info("----------------------------my starter started---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
