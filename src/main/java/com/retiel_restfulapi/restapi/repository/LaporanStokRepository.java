package com.retiel_restfulapi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.retiel_restfulapi.restapi.model.LogActivityModel;

@Repository
public interface LaporanStokRepository extends JpaRepository<LogActivityModel, Integer> {

    @Query(value = "CALL sp_get_laporan_stok()", nativeQuery = true)
    List<Object[]> getLaporanStok();
}
