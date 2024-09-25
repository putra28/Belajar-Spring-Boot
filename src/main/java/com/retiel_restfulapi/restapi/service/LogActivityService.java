package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.LogActivityRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class LogActivityService {
    @Autowired
    private LogActivityRepository logActivityRepository;

    public ResponseEntity<Map<String, Object>> getLogActivity() {
        List<Object[]> results = logActivityRepository.getLogActivity();
        List<Map<String, Object>> logActivityModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data log aktivitas.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> logActivityModel = new LinkedHashMap<>();
            logActivityModel.put("M_idLog", result[0]);
            logActivityModel.put("M_idPengguna", result[1]);
            logActivityModel.put("M_namePengguna", result[2].toString());
            logActivityModel.put("M_activityLog", result[3].toString());
            logActivityModel.put("M_DateActivity", ((Timestamp) result[4]).toLocalDateTime());

            logActivityModels.add(logActivityModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Log Aktifitas.");
        response.put("Data", logActivityModels);

        return ResponseEntity.ok(response);
    }
}
