package com.retiel_restfulapi.restapi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.service.ProdukService;

@RestController
@RequestMapping("/retielAPI")
public class ProdukController {
    @Autowired
    private ProdukService produkService;

    @GetMapping("/getDataProduk")
    public ResponseEntity<Map<String, Object>> getDataProduk() {
        return produkService.getDataProduk();
    }
}
