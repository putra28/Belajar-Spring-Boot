package com.retiel_restfulapi.restapi.service;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.LaporanStokRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class LaporanStokService {
    @Autowired
    private LaporanStokRepository laporanStokRepository;

    public ResponseEntity<Map<String, Object>> getLaporanStok() {
        List<Object[]> results = laporanStokRepository.getLaporanStok();
        List<Map<String, Object>> laporanstokModels = new ArrayList<>();

        if (results.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Status", "error");
            response.put("Message", "Tidak ada data laporan stok.");
            return ResponseEntity.ok(response);
        }

        for (Object[] result : results) {
            Map<String, Object> laporanstokModel = new LinkedHashMap<>();
            laporanstokModel.put("M_idStok", result[0]);
            laporanstokModel.put("M_namaProduk", result[1].toString());
            laporanstokModel.put("M_stokSemula", result[2]);
            laporanstokModel.put("M_stokAkhir", result[3]);
            laporanstokModel.put("M_perubahanStok", result[4]);
            laporanstokModel.put("M_actionStok", result[5].toString());
            laporanstokModel.put("M_dateLaporan",  ((Timestamp) result[6]).toLocalDateTime());

            laporanstokModels.add(laporanstokModel);
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Laporan");
        response.put("Data", laporanstokModels);

        return ResponseEntity.ok(response);
    }
}
