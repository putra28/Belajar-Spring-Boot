package com.retiel_restfulapi.restapi.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retiel_restfulapi.restapi.model.PenggunaModel;
import com.retiel_restfulapi.restapi.repository.LoginRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public PenggunaModel login(String M_usernamePengguna, String M_passwordPengguna) {
        List<Object[]> results = loginRepository.login(M_usernamePengguna, M_passwordPengguna);

        if (results.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }   

        Object[] data = results.get(0);
        if (data.length == 2) {
            // Jika Data Kosong
            PenggunaModel penggunamodel = new PenggunaModel();
            penggunamodel.setM_loginStatus(data[0].toString());
            penggunamodel.setM_Error_message(data[1].toString());
            return penggunamodel;
        } else {
            // Jika sukses
            PenggunaModel penggunamodel = new PenggunaModel();
            penggunamodel.setM_idPengguna((Integer) data[0]);
            penggunamodel.setM_namePengguna(data[1].toString());
            penggunamodel.setM_usernamePengguna(data[2].toString());
            penggunamodel.setM_rolePengguna(data[3].toString());
            penggunamodel.setM_createdAt((Timestamp) data[4]);
            penggunamodel.setM_updatedAt((Timestamp) data[5]);
            penggunamodel.setM_loginStatus(data[6].toString());
            return penggunamodel;
        }
    }

}
