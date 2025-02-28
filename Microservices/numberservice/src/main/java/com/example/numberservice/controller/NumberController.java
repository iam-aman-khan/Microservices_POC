package com.example.numberservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/numbers")
public class NumberController {
    @GetMapping("/{start}/{end}")
    public List<Integer> generateNumbers(@PathVariable int start, @PathVariable int end) {
        return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
