package com.json.example.jsonExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/json/save", method = RequestMethod.POST, produces = "application/json")
    public PatientProfile json(@RequestBody PatientProfile dto) throws JsonProcessingException {
        PatientProfile dto1 = jsonRepo.save(dto);
        return dto1;
    }
}
