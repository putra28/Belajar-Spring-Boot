package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.PenggunaRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PenggunaService {
    @Autowired
    private PenggunaRepository penggunaRepository;

    public ResponseEntity<Map<String, Object>> getDataPengguna() {
        List<Object[]> results = penggunaRepository.getDataPengguna();
        List<Map<String, Object>> PenggunaModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data pengguna.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> PenggunaModel = new LinkedHashMap<>();
            PenggunaModel.put("M_idPengguna", result[0]);
            PenggunaModel.put("M_namaPengguna", result[1]);
            PenggunaModel.put("M_usernamePengguna", result[2].toString());
            PenggunaModel.put("M_passwordPengguna", result[3].toString());
            PenggunaModel.put("M_rolePengguna", result[4].toString());
            PenggunaModel.put("M_createdAt", ((Timestamp) result[5]).toLocalDateTime());
            PenggunaModel.put("M_updatedAt", ((Timestamp) result[6]).toLocalDateTime());

            PenggunaModels.add(PenggunaModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Pengguna.");
        response.put("Data", PenggunaModels);

        return ResponseEntity.ok(response);
    }
}
