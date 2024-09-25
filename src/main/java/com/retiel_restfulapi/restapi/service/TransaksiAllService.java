package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.TransaksiAllRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TransaksiAllService {
    @Autowired
    private TransaksiAllRepository transaksiAllRepository;

    @SuppressWarnings("unchecked")
    public ResponseEntity<Map<String, Object>> getAllTransaksi() {
        List<Object[]> transaksiResults = transaksiAllRepository.getAllTransaksi();
        List<Object[]> detailResults = transaksiAllRepository.getDetailTransaksi();
        
        // Map to hold transaction details
        Map<Integer, Map<String, Object>> transaksiMap = new LinkedHashMap<>();

        // Process transaction results
        for (Object[] data : transaksiResults) {
            Map<String, Object> transaksiModel = new LinkedHashMap<>();
            Integer idTransaksi = (Integer) data[0];
            transaksiModel.put("M_idTransaksi", idTransaksi);
            transaksiModel.put("M_idPengguna", data[1]);
            transaksiModel.put("M_namePengguna", data[2].toString());
            transaksiModel.put("M_namaPelanggan", data[3].toString());
            transaksiModel.put("M_quantityTransaksi", data[4]);
            transaksiModel.put("M_totalPayment", data[5]);
            transaksiModel.put("M_totalPrice", data[6]);
            transaksiModel.put("M_totalChange", data[7]);
            transaksiModel.put("M_dateTransaksi", ((Timestamp) data[8]).toLocalDateTime());
            
            transaksiMap.put(idTransaksi, transaksiModel);
        }

        // Process detail results and associate with transactions
        for (Object[] data : detailResults) {
            Integer idTransaksi = (Integer) data[1];
            Map<String, Object> transaksiModel = transaksiMap.get(idTransaksi);
            
            if (transaksiModel != null) {
                List<Map<String, Object>> detailList = (List<Map<String, Object>>) transaksiModel.get("M_detailTransaksi");
                
                if (detailList == null) {
                    detailList = new ArrayList<>();
                    transaksiModel.put("M_detailTransaksi", detailList);
                }
                
                Map<String, Object> detailModel = new LinkedHashMap<>();
                detailModel.put("M_idDetailTransaksi", data[0]);
                detailModel.put("M_idTransaksi", idTransaksi);
                detailModel.put("M_nameKategori", data[2].toString());
                detailModel.put("M_nameSubkategori", data[3].toString());
                detailModel.put("M_nameProduk", data[4].toString());
                detailModel.put("M_priceProduk", data[5]);
                detailModel.put("M_quantityProduk", data[6]);

                detailList.add(detailModel);
            }
        }

        // Collect the response
        List<Map<String, Object>> transaksiList = new ArrayList<>(transaksiMap.values());
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Status", "success");
        response.put("Message", "Berhasil Mengambil Data Transaksi");
        response.put("Data", transaksiList);

        return ResponseEntity.ok(response);
    }
}
