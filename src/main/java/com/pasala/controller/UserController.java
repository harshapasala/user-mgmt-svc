package com.pasala.controller;


import com.pasala.config.KafkaConfig;
import com.pasala.model.User;
import com.pasala.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    private KafkaProducerService kafkaProducerService;
    public UserController( KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
    @GetMapping("/ping")
    public String sample() {
        return "pong";
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        String uid =java.util.UUID.randomUUID().toString();
        kafkaProducerService.sendMessage(user,uid);
        log.info(String.valueOf(user));
    }

    @GetMapping("/users/{uid}")
    public User getUserData(@PathVariable("uid") String uid) {
        return new User();
    }

}
