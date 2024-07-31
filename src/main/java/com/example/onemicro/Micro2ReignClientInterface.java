package com.example.onemicro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TWOMICRO")
public interface Micro2ReignClientInterface {

    @GetMapping("/micro2/get")
    ResponseEntity<String> getMicro1();

}
