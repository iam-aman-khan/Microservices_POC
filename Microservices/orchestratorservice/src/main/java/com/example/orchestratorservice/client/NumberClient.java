package com.example.orchestratorservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "number-service")
public interface NumberClient {
    @GetMapping("/numbers/{start}/{end}")
    List<Integer> getNumbers(@PathVariable int start, @PathVariable int end);
}

