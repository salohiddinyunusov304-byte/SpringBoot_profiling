package uz.pdp.spring_profiling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.spring_profiling.service.SimpleService;

@RestController
@RequestMapping("/api/simple")
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleService simpleService;

    @GetMapping("/message")
    public String getMessage() {
        simpleService.getMessage();
        return "Message from controller";
    }
}
