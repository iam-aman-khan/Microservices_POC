package com.example.orchestratorservice.controller;

import com.example.orchestratorservice.client.NumberClient;
import com.example.orchestratorservice.client.PrimeClient;
import com.example.orchestratorservice.client.HappyClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {
    private final NumberClient numberClient;
    private final PrimeClient primeClient;
    private final HappyClient happyClient;

    public OrchestratorController(NumberClient numberClient, PrimeClient primeClient, HappyClient happyClient) {
        this.numberClient = numberClient;
        this.primeClient = primeClient;
        this.happyClient = happyClient;
    }

    // Get All Numbers in a Range
    @GetMapping("/numbers")
    public List<Integer> getNumbers(@RequestParam int start, @RequestParam int end) {
        return numberClient.getNumbers(start, end);
    }

    // Get Prime Numbers in a Range
    @GetMapping("/prime")
    public List<Integer> getPrimeNumbers(@RequestParam int start, @RequestParam int end) {
        List<Integer> numbers = numberClient.getNumbers(start, end);
        return numbers.stream().filter(primeClient::isPrime).collect(Collectors.toList());
    }

    // Get Happy Numbers in a Range
    @GetMapping("/happy")
    public List<Integer> getHappyNumbers(@RequestParam int start, @RequestParam int end) {
        List<Integer> numbers = numberClient.getNumbers(start, end);
        return numbers.stream().filter(happyClient::isHappy).collect(Collectors.toList());
    }

    //Get Numbers That Are Both Prime & Happy
    @GetMapping("/prime-happy")
    public List<Integer> getPrimeAndHappyNumbers(@RequestParam int start, @RequestParam int end) {
        List<Integer> numbers = numberClient.getNumbers(start, end);
        return numbers.stream()
                .filter(num -> primeClient.isPrime(num) && happyClient.isHappy(num))
                .collect(Collectors.toList());
    }
}
