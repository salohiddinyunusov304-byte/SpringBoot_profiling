package uz.pdp.spring_profiling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class SimpleService {

//    @Scheduled(fixedDelay = 3000) - har 5 sekunda ishlatadi
//    public void showTime() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//
//        log.info("Time: {}", dateFormat.format(new Date()));
//        TimeUnit.SECONDS.sleep(2);
//    }

    // har 3 sekunda ishlaydi
//    @Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS)
//    public void showTime() throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//
//        log.info("Time: {}", dateFormat.format(new Date()));
//        TimeUnit.SECONDS.sleep(2);
//    }

    @Scheduled(cron = "* */10 * * * ?") // har 1 sekundda ishlaydi
    public void showTime() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        log.info("Time: {}", dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(2);
    }
}
