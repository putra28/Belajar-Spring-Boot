package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.repository.TransaksiByKasirRepository;
import com.retiel_restfulapi.restapi.repository.TransaksiAllRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TransaksiByKasirService {

    @Autowired
    private TransaksiByKasirRepository transaksiByKasirRepository;
    @Autowired
    private TransaksiAllRepository transaksiAllRepository;

    public ResponseEntity<Map<String, Object>> getPenggunaTransaksi(Integer idPengguna) {
        List<Object[]> transaksiResults = transaksiByKasirRepository.getPenggunaTransaksi(idPengguna);
        List<Object[]> detailResults = transaksiAllRepository.getDetailTransaksi();  // Ambil detail transaksi
        Map<String, Object> response = new LinkedHashMap<>();

        if (transaksiResults.isEmpty()) {
            // Jika hasil kosong, berarti terjadi kesalahan
            response.put("Status", "error");
            response.put("Message", "Tidak ada data ditemukan untuk id pengguna: " + idPengguna);
            return ResponseEntity.ok(response);
        }

        // Ambil status dan message dari hasil stored procedure
        Object[] firstResult = transaksiResults.get(0);

        // Jika status 'failed', kembalikan response dengan pesan error
        if (firstResult.length == 2) {
            response.put("Status", firstResult[0].toString());
            response.put("Message", firstResult[1].toString());
            return ResponseEntity.ok(response);
        }

        // Jika status 'success', proses hasil transaksi
        List<Map<String, Object>> transaksiModels = new ArrayList<>();

        for (Object[] data : transaksiResults) {
            Map<String, Object> transaksiModel = new LinkedHashMap<>();
            transaksiModel.put("M_idTransaksi", data[0]);
            transaksiModel.put("M_idPengguna", data[1]);
            transaksiModel.put("M_namePengguna", data[2].toString());
            transaksiModel.put("M_namaPelanggan", data[3].toString());
            transaksiModel.put("M_quantityTransaksi", data[4]);
            transaksiModel.put("M_totalPayment", data[5]);
            transaksiModel.put("M_totalPrice", data[6]);
            transaksiModel.put("M_totalChange", data[7]);
            transaksiModel.put("M_dateTransaksi", ((Timestamp) data[8]).toLocalDateTime());

            // Buat list untuk detail transaksi terkait dengan id_transaksi ini
            List<Map<String, Object>> detailTransaksi = new ArrayList<>();

            for (Object[] detail : detailResults) {
                if (data[0].equals(detail[1])) {  // Cocokkan id_transaksi
                    Map<String, Object> detailModel = new LinkedHashMap<>();
                    detailModel.put("M_idDetailTransaksi", detail[0]);
                    detailModel.put("M_idTransaksi", detail[1]);
                    detailModel.put("M_nameKategori", detail[2].toString());
                    detailModel.put("M_nameSubKategori", detail[3].toString());
                    detailModel.put("M_nameProduk", detail[4].toString());
                    detailModel.put("M_priceProduk", detail[5]);
                    detailModel.put("M_quantityProduk", detail[6]);

                    detailTransaksi.add(detailModel);
                }
            }

            // Masukkan detail transaksi ke transaksi terkait
            transaksiModel.put("M_detailTransaksi", detailTransaksi);
            transaksiModels.add(transaksiModel);
        }

        // Set hasil response
        response.put("Status", "success");
        response.put("Message", "Berhasil Mendapatkan Data Transaksi");
        response.put("Data", transaksiModels);

        return ResponseEntity.ok(response);
    }
}
