package cz.erms.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ErmsEjbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErmsEjbApplication.class, args);
    }

}

@RestController
class TestController {

    @GetMapping("/test")
    String hello() {
        return "Hello World";
    }
}