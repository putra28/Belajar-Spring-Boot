package com.retiel_restfulapi.restapi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.service.PemasokService;

@RestController
@RequestMapping("/retielAPI")
public class PemasokController {
    @Autowired
    private PemasokService pemasokService;
    
    @GetMapping("/getPemasok")
    public ResponseEntity<Map<String, Object>> getDataPemasok() {
        return pemasokService.getDataPemasok();
    }
}
