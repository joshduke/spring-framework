package learn.spring.cloud.eurekaclient1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthDemoController {

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, Welcome " + name;
    }

}
