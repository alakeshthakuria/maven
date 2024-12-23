package com.github.alakeshthakuria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a", defaultValue = "0") int a,
                            @RequestParam(value = "b", defaultValue = "0") int b,
                            @RequestParam(value = "operation", defaultValue = "add") String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return "Result: " + (a + b);
            case "subtract":
                return "Result: " + (a - b);
            case "multiply":
                return "Result: " + (a * b);
            case "divide":
                return b != 0 ? "Result: " + (a / b) : "Error: Division by zero";
            default:
                return "Error: Unsupported operation";
        }
    }
}

