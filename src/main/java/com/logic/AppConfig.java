package com.logic;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class AppConfig {

    @Scheduled(fixedDelay = 3000)
    public void getDownSite() {
    }
}
