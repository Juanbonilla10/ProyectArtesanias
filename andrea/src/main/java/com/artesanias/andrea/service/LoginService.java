/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artesanias.andrea.service;

import com.artesanias.andrea.entity.LoginEntity;
import com.artesanias.andrea.repository.LoginRepository;
import com.artesanias.andrea.util.LoginDecrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandra.Agudelo
 */
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean createUser(LoginEntity loginEntity) {
        try {
            if (loginRepository.createUser(loginEntity)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al crear el usuario" + e.getMessage());
            return false;
        }
    }

    public LoginEntity GetUser() {
        try {
            LoginEntity loginEntity = new LoginEntity();
            LoginDecrypt loginDecrypt = new LoginDecrypt();
            loginEntity = (LoginEntity) loginRepository.GetUser();
            loginEntity.setPasswordUser(loginDecrypt.decrypt(loginEntity.getPasswordUser()));
            return loginEntity;
        } catch (Exception e) {
            return new LoginEntity();
        }
    }

}
