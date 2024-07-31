package com.example.onemicro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    public RestTemplate restTemplate;

    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/micro1/get")
    public ResponseEntity<String> getMicro1(){

        String string = "";
        string = restTemplate.getForObject("http://192.168.56.1:8081/micro2/get", String.class);

        return new ResponseEntity<>("microservice 1 + " + string, HttpStatus.OK);
    }

}
