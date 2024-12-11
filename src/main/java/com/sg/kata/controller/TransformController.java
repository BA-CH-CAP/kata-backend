package com.sg.kata.controller;

import com.sg.kata.service.TransformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/transform")
public class TransformController {

    public static final String URL_FRONT = "http://localhost:4200";
    private final TransformService ts;

    public TransformController(TransformService ts){
        this.ts = ts;
    }

    @CrossOrigin(origins = URL_FRONT)
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> transform(@RequestParam Integer num){

        if(num == null || num <0 || num > 100) {
            log.error("Error during transformation : {}",num);
            return ResponseEntity.badRequest().build();
        }
        
        String result = ts.tranformNumToString(num);

        log.info("result for {} : {}", num, result);
        return ResponseEntity.ok(result);
    }
}
