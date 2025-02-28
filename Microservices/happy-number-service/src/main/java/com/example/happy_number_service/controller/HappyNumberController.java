package com.example.happy_number_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/happy")
public class HappyNumberController {

    @GetMapping("/{number}")
    public boolean isHappy(@PathVariable int number) {
        return isHappyNumber(number);
    }

    private boolean isHappyNumber(int num) {
        Set<Integer> seen = new HashSet<>();
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = sumOfSquares(num);
        }
        return num == 1;
    }

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}

