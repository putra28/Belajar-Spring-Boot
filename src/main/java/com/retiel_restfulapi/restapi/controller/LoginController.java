package com.retiel_restfulapi.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retiel_restfulapi.restapi.model.LoginRequest;
import com.retiel_restfulapi.restapi.model.PenggunaModel;
import com.retiel_restfulapi.restapi.service.LoginService;

@RestController
@RequestMapping("/retielAPI")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public PenggunaModel login(@RequestBody LoginRequest loginrequest) {
        System.out.println("Data Sent: " + loginrequest);
        return loginService.login(loginrequest.getUsernamePengguna(), loginrequest.getPasswordPengguna());
    }

}