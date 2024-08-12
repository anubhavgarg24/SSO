package com.example.ssoDemo.sso.controller;

import com.example.ssoDemo.sso.model.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    @Value("${catAPI}")
    String catAPI;
    @Value("{gotAPI}")
    String gotAPI;
    @GetMapping("/cat")
    public String catFact(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.getForEntity(catAPI, String.class);
        String jsonResponse = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<Cat> resp = objectMapper.readValue(jsonResponse, new TypeReference<>() {
            });
            return resp.get(0).getFact();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/ip")
    public String getIp(HttpServletRequest request) {
        return request.getLocalAddr();
    }
}
