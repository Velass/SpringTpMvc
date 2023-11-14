package fr.diginamic.springmvc.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {
    @Scheduled(cron = "${cron.expression}")
    public void executeTask() {
        System.out.println("Tâche cron exécutée à : " + LocalDateTime.now());
    }
}
