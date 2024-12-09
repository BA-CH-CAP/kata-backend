package com.sg.kata.controller;

import com.sg.kata.service.TransformService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class TranformControllerTest {

    @Test
    void should_ReturnSuccess_When_TransformIsDone() {
        TransformService ts = new TransformService();
        TranformController trController = new TranformController(ts);

        ResponseEntity responseEntity = trController.transform(1);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @ParameterizedTest
    @CsvSource({"-1", "101"})
    public void should_ReturnBadRequest_When_WrongParamProvided(Integer num){

        TranformController trController = new TranformController(null);

        ResponseEntity responseEntity = trController.transform(num);

        assertEquals(400, responseEntity.getStatusCode().value());
    }

    @Test
    public void should_ReturnBadRequest_When_WrongNullParamProvided(){

        TranformController trController = new TranformController(null);

        ResponseEntity responseEntity = trController.transform(null);

        assertEquals(400, responseEntity.getStatusCode().value());
    }


}