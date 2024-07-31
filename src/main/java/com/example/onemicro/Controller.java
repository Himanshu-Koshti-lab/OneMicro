package com.example.onemicro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    public RestTemplate restTemplate;

    public Micro2ReignClientInterface micro2ReignClientInterface;

    public Controller(RestTemplate restTemplate, Micro2ReignClientInterface micro2ReignClientInterface) {
        this.restTemplate = restTemplate;
        this.micro2ReignClientInterface = micro2ReignClientInterface;
    }

    @GetMapping("/micro1/get")
    public ResponseEntity<String> getMicro1(){

        String string = "";
//        string = restTemplate.getForObject("http://TWOMICRO/micro2/get", String.class);
        string = micro2ReignClientInterface.getMicro1().getBody();
        System.out.println("Called..");
        return new ResponseEntity<>("microservice 1 + " + string, HttpStatus.OK);
    }

}
