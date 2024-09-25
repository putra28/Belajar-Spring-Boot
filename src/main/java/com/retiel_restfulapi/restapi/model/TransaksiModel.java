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
public class TransaksiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("M_idTransaksi")
    private Integer M_idTransaksi;

    @JsonProperty("M_idPengguna")
    private Integer M_idPengguna;

    @JsonProperty("M_namaPengguna")
    private String M_namePengguna;

    @JsonProperty("M_namaPelanggan")
    private String M_namaPelanggan;

    @JsonProperty("M_quantityTransaksi")
    private Integer M_quantityTransaksi;

    @JsonProperty("M_totalPayment")
    private Integer M_totalPayment;
    
    @JsonProperty("M_totalPrice")
    private Integer M_totalPrice;
    
    @JsonProperty("M_totalChange")
    private Integer M_totalChange;

    @JsonProperty("M_dateTransaksi")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp M_dateTransaksi;
    
    @JsonProperty("M_statusGetDB")
    private String M_statusGetDB;

    @JsonProperty("M_messageGetDB")
    private String M_messageGetDB;
    
}