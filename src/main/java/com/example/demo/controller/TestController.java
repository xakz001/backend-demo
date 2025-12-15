package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/ping")
    public Map<String, String> ping() {
        return Map.of(
                "from", "backend",
                "message", "PING OK",
                "ts", Instant.now().toString()
        );
    }
}
