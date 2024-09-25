package com.retiel_restfulapi.restapi.service;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.ProdukRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;

    public ResponseEntity<Map<String, Object>> getDataProduk() {
        List<Object[]> results = produkRepository.getDataProduk();
        List<Map<String, Object>> produkModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data produk.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> produkModel = new LinkedHashMap<>();
            produkModel.put("M_idProduk", result[0]);
            produkModel.put("M_namaKategori", result[1].toString());
            produkModel.put("M_namaSubKategori", result[2].toString());
            produkModel.put("M_namaProduk", result[3].toString());
            produkModel.put("M_hargaProduk", result[4]);
            produkModel.put("M_stokProduk", result[5]);
            produkModel.put("M_createdAt",  ((Timestamp) result[6]).toLocalDateTime());
            produkModel.put("M_updatedAt",  ((Timestamp) result[7]).toLocalDateTime());

            produkModels.add(produkModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Produk");
        response.put("Data", produkModels);

        return ResponseEntity.ok(response);
    }
}
