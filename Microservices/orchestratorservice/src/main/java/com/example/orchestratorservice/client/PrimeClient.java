package com.example.orchestratorservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "prime-service")
public interface PrimeClient {
    @GetMapping("/prime/{number}")
    boolean isPrime(@PathVariable int number);
}
