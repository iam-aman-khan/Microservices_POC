package com.example.primeservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prime")
public class PrimeController {
    @GetMapping("/{number}")
    public boolean isPrime(@PathVariable int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
