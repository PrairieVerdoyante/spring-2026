package ch.hearc.jee2024.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello Spring Boot!";
    }

   @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "Hello World!";
    }

    @PostMapping("/test123")
    public @ResponseBody String test123() {
        return "test.";
    }
}
