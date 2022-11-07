/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artesanias.andrea.repository;

import com.artesanias.andrea.entity.LoginEntity;
import com.artesanias.andrea.repository.crud.LoginRepositoryCrud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 *
 * @author Alejandra.Agudelo
 */
@Service
public class LoginRepository {

    @Autowired
    private LoginRepositoryCrud loginRepositoryCrud;

    public boolean createUser(LoginEntity loginEntity) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(loginEntity.getPasswordUser().getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            loginEntity.setPasswordUser(hashtext);
            loginRepositoryCrud.save(loginEntity);
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear la entidad login " + e.getMessage());
            return false;
        }
    }
    
    public List<LoginEntity> GetUser(){
        return loginRepositoryCrud.findAll();
    }

}
