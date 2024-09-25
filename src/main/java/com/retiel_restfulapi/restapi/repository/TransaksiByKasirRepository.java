package com.retiel_restfulapi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.retiel_restfulapi.restapi.model.TransaksiModel;

@Repository
public interface TransaksiByKasirRepository extends JpaRepository<TransaksiModel, Integer> {

    @Procedure("sp_get_pengguna_histrori_transaksi")
    List<Object[]> getPenggunaTransaksi(@Param("p_id_pengguna") Integer idPengguna);

}
