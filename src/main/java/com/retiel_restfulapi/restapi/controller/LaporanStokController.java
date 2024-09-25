package com.retiel_restfulapi.restapi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.service.LaporanStokService;

@RestController
@RequestMapping("/retielAPI")
public class LaporanStokController {
    @Autowired
    private LaporanStokService laporanStokService;

    @GetMapping("/getLaporanStok")
    public ResponseEntity<Map<String, Object>> getLaporanStok() {
        return laporanStokService.getLaporanStok();
    }
}
