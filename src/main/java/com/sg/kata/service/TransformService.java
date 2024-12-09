package com.sg.kata.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransformService {

    public static final String EMPTY = "";
    public static Map<Integer, String> devidMap = new LinkedHashMap<>();
    public static Map<String, String> strMap = new LinkedHashMap<>();

    static {
        devidMap.put(3, "FOO");
        devidMap.put(5, "BAR");

        strMap.put("5", "BAR");
        strMap.put("3", "FOO");
        strMap.put("7", "QUIX");
    }

    public String tranformNumToString(Integer num){

        String strNum = String.valueOf(num);

        String result = devidMap.keySet().stream().filter(k -> num % k == 0).map(k -> devidMap.get(k)).collect(Collectors.joining());

        result += strMap.keySet().stream().filter(k -> strNum.contains(k)).map(k -> strResultByOccurence(k, strNum)).collect(Collectors.joining());

        if(EMPTY.equals(result)){
            result = strNum;
        }

        return result;
    }

    private String strResultByOccurence(String key, String strNum) {
        String result = "";

        for(char c : strNum.toCharArray()){
            if(c == key.charAt(0)){
                result += strMap.get(key);
            };
        }

        return result;
    }

}
