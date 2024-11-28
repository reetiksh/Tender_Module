package com.nscs.SBMaster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import com.nscs.SBMaster.model.commonParameter;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonParameterService {

    @Value("${jBoss.api.url}")
    private String jBossApiUrl;


    @Autowired
    private ObjectMapper objectMapper;

    public commonParameter fetchAndStoreCommonParameter() throws JsonProcessingException{

        commonParameter commonParameter=null;

        RestTemplate restTemplate= new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
// For JSON parsing



        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity= new HttpEntity<>(headers);
        String apiUrl=jBossApiUrl+" /GetCpr";

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl,requestEntity, String.class);

        if(response.getStatusCode().is2xxSuccessful()){
            String jsonResponse = response.getBody();
            commonParameter = objectMapper.readValue(jsonResponse, commonParameter.class);
            System.out.println("Data fetched successfully!");

        }else {
            System.out.println("Failed to fetch data: HTTP Status " + response.getStatusCode());

        }

        return commonParameter;
    }

}
