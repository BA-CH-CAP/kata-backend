package com.sg.kata.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TransformServiceTest {

    TransformService ts;

    @BeforeEach
    public void init(){
        ts = new TransformService();
    }

    @ParameterizedTest
    @CsvSource({ "1 1", "3 FOOFOO", "5 BARBAR", "7 QUIX" , "9 FOO"  , "51 FOOBAR", "53 BARFOO", "33 FOOFOOFOO" , "15 FOOBARBAR"})
    public void should_ReturnStr_When_NumIsProvided(String keyValue){

        String[] keyValArray = keyValue.split(" ");

        int key = Integer.parseInt(keyValArray[0]);
        String val = keyValArray[1];

        assertEquals(val, ts.tranformNumToString(key));
    }

}