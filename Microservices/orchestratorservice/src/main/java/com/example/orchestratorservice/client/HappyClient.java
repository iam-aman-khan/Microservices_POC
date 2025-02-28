package com.example.orchestratorservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "happy-number-service")
public interface HappyClient {
    @GetMapping("/happy/{number}")
    boolean isHappy(@PathVariable int number);
}
