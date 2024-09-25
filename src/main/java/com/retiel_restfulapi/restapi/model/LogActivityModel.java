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
public class LogActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("M_idLog")
    private Integer M_idLog;

    @JsonProperty("M_idPengguna")
    private Integer M_idPengguna;

    @JsonProperty("M_namaPengguna")
    private String M_namePengguna;

    @JsonProperty("M_activityLog")
    private String M_activityLog;

    @JsonProperty("M_DateActivity")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp M_DateActivity;

}
