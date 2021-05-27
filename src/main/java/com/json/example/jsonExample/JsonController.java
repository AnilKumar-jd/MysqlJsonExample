package com.json.example.jsonExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class JsonController {

    @Autowired
    JsonRepo jsonRepo;

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public List<PatientProfile> json() throws JsonProcessingException {
        List<PatientProfile> dto = jsonRepo.findAll();
        return dto;
    }
}
