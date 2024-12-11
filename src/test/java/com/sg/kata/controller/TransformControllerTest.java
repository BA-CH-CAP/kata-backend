package com.sg.kata.controller;

import com.sg.kata.service.TransformService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class TransformControllerTest {

    @Test
    void should_ReturnSuccess_When_TransformIsDone() {
        TransformService ts = new TransformService();
        TransformController trController = new TransformController(ts);

        ResponseEntity<String> responseEntity = trController.transform(1);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @ParameterizedTest
    @CsvSource({"-1", "101"})
    public void should_ReturnBadRequest_When_WrongParamProvided(Integer num){

        TransformController trController = new TransformController(null);

        ResponseEntity<String> responseEntity = trController.transform(num);

        assertEquals(400, responseEntity.getStatusCode().value());
    }

    @Test
    public void should_ReturnBadRequest_When_WrongNullParamProvided(){

        TransformController trController = new TransformController(null);

        ResponseEntity<String> responseEntity = trController.transform(null);

        assertEquals(400, responseEntity.getStatusCode().value());
    }


}