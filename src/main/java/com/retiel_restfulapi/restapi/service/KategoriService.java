package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.KategoriRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    public ResponseEntity<Map<String, Object>> getDataKategori() {
        List<Object[]> results = kategoriRepository.getDataKategori();
        List<Map<String, Object>> KategoriModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data kategori.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> KategoriModel = new LinkedHashMap<>();
            KategoriModel.put("M_idKategori", result[0]);
            KategoriModel.put("M_namaKategori", result[1]);
            KategoriModel.put("M_namaSubKategori", result[2].toString());
            KategoriModel.put("M_createdAt", ((Timestamp) result[3]).toLocalDateTime());
            KategoriModel.put("M_updatedAt", ((Timestamp) result[4]).toLocalDateTime());

            KategoriModels.add(KategoriModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Kategori.");
        response.put("Data", KategoriModels);

        return ResponseEntity.ok(response);
    }
}
