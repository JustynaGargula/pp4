package pl.justyna;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/hello")
    String hello(){
        return "Hello World!";
    }
}
