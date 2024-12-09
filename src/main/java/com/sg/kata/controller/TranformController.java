package com.sg.kata.controller;

import com.sg.kata.service.TransformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tranform")
public class TranformController {

    private final TransformService ts;

    public TranformController(TransformService ts){
        this.ts = ts;
    }

    @GetMapping
    public ResponseEntity transform(@RequestParam Integer num){

        if(num == null || num <0 || num > 100) {
            return ResponseEntity.badRequest().build();
        }
        
        String result = ts.tranformNumToString(num);

        return ResponseEntity.ok(result);
    }
}
