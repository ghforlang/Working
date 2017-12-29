package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/29 11:02
 */
@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }
}
