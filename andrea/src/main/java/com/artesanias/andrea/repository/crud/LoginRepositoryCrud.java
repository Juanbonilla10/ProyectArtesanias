/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.artesanias.andrea.repository.crud;

import com.artesanias.andrea.entity.LoginEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandra.Agudelo
 */
@Repository
public interface LoginRepositoryCrud extends MongoRepository<LoginEntity, Integer>{
    
}
