package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.PemasokRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PemasokService {
    @Autowired
    private PemasokRepository pemasokRepository;

    public ResponseEntity<Map<String, Object>> getDataPemasok() {
        List<Object[]> results = pemasokRepository.getDataPemasok();
        List<Map<String, Object>> PemasokModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data pemasok.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> PemasokModel = new LinkedHashMap<>();
            PemasokModel.put("M_idPengguna", result[0]);
            PemasokModel.put("M_namaPemasok", result[1]);
            PemasokModel.put("M_kontakPemasok", result[2].toString());
            PemasokModel.put("M_alamatPemasok", result[3].toString());
            PemasokModel.put("M_createdAt", ((Timestamp) result[4]).toLocalDateTime());
            PemasokModel.put("M_updatedAt", ((Timestamp) result[5]).toLocalDateTime());

            PemasokModels.add(PemasokModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Pemasok.");
        response.put("Data", PemasokModels);

        return ResponseEntity.ok(response);
    }
}
