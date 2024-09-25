package com.retiel_restfulapi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.retiel_restfulapi.restapi.model.PenggunaModel;

@Repository
public interface LoginRepository extends JpaRepository<PenggunaModel, Integer> { // Assuming idPengguna is Integer

    @Procedure("sp_login_retiel")
    List<Object[]> login(@Param("p_username_login") String username, @Param("p_password_login") String password);
}