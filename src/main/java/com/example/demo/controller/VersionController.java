package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/api/version")
    public Map<String, String> version() {
        return Map.of(
                "service", "backend-demo",
                "version", "3.0.0",
                "buildTime", Instant.now().toString()
        );
    }
}
