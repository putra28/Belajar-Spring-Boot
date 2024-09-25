package com.retiel_restfulapi.restapi.model;


import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LaporanStokModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("M_idStok")
    private Integer M_idStok;

    @JsonProperty("M_namaProduk")
    private String M_namaProduk;

    @JsonProperty("M_stokSemula")
    private Integer M_stokSemula;
    
    @JsonProperty("M_stokAkhir")
    private Integer M_stokAkhir;
    
    @JsonProperty("M_perubahanStok")
    private Integer M_perubahanStok;

    @JsonProperty("M_actionStok")
    private String M_actionStok;

    @JsonProperty("M_dateLaporan")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp M_dateLaporan;

}