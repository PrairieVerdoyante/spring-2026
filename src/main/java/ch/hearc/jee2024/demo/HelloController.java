package ch.hearc.jee2024.demo;

import org.springframework.web.bind.annotation.GetMapping;
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
}
