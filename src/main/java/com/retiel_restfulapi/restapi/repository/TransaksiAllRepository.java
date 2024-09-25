package com.retiel_restfulapi.restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.retiel_restfulapi.restapi.model.TransaksiModel;

@Repository
public interface TransaksiAllRepository extends JpaRepository<TransaksiModel, Integer> {
    
    @Query(value = "CALL sp_get_all_histori_transaksi()", nativeQuery = true)
    List<Object[]> getAllTransaksi();
    
    @Query(value = "CALL sp_get_all_detail_transaksi()", nativeQuery = true)
    List<Object[]> getDetailTransaksi();
}
