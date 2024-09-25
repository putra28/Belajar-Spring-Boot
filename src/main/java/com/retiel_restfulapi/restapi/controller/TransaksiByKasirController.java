package com.retiel_restfulapi.restapi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.model.TransaksiRequest;
import com.retiel_restfulapi.restapi.service.TransaksiAllService;
import com.retiel_restfulapi.restapi.service.TransaksiByKasirService;

@RestController
@RequestMapping("/retielAPI")
public class TransaksiByKasirController {

    @Autowired
    private TransaksiByKasirService tKasirService;
    @Autowired
    private TransaksiAllService transaksiAllService;
    
    @PostMapping("/getTransaksiByKasir")
    public ResponseEntity<Map<String, Object>> getPenggunaTransaksi(@RequestBody TransaksiRequest transaksiRequest) {
        // Logging to track incoming data (use a logger instead of println)
        System.out.println("Data Sent: " + transaksiRequest);

        // Fetch the response from service
        return tKasirService.getPenggunaTransaksi(transaksiRequest.getIdPengguna());
    }

    @GetMapping("/getAllTransaksi")
    public ResponseEntity<Map<String, Object>> getAllTransaksi() {
        return transaksiAllService.getAllTransaksi();
    }
}
