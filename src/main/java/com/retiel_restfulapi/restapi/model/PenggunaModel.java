package com.retiel_restfulapi.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
public class PenggunaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("M_idPengguna")
    private Integer M_idPengguna;

    @JsonProperty("M_namePengguna")
    private String M_namePengguna;

    @JsonProperty("M_usernamePengguna")
    private String M_usernamePengguna;

    @JsonProperty("M_rolePengguna")
    private String M_rolePengguna;

    @JsonProperty("M_createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp M_createdAt;

    @JsonProperty("M_updatedAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp M_updatedAt;

    @JsonProperty("M_loginStatus")
    private String M_loginStatus;
    
    @JsonProperty("M_Error_message")
    private String M_Error_message;
}
