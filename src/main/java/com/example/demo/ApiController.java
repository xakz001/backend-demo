package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/api/time")
    public Map<String, String> getTime() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from backendф");
        response.put(
                "time",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        return response;
    }
}
