/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artesanias.andrea.controller;

import com.artesanias.andrea.entity.LoginEntity;
import com.artesanias.andrea.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandra.Agudelo
 */
@RestController
@RequestMapping(value = "api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LoginController{
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody LoginEntity loginEntity){
        
        if (loginService.createUser(loginEntity)) {
            return new ResponseEntity(loginEntity, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(loginEntity, HttpStatus.BAD_REQUEST);
        }       
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity getUserAll(){
        return new ResponseEntity(loginService.GetUser(), HttpStatus.CREATED);
    }
            
    
}
