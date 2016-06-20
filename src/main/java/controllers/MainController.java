package controllers;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {
        "model"
})
@EnableJpaRepositories(basePackages = {
        "repository"
})

public class MainController {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }



    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}
