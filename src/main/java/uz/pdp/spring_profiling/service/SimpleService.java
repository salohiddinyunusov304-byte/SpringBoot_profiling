package uz.pdp.spring_profiling.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Async
    public void getMessage() {
        System.out.println("Executing getMessage method in thread: " + Thread.currentThread().getName());
    }
}
