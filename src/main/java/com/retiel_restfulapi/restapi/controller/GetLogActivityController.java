package com.retiel_restfulapi.restapi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.service.LogActivityService;

@RestController
@RequestMapping("/retielAPI")
public class GetLogActivityController {
    @Autowired
    private LogActivityService logActivityService;
    
    @GetMapping("/getLogActivity")
    public ResponseEntity<Map<String, Object>> getLogActivity() {
        return logActivityService.getLogActivity();
    }
}
