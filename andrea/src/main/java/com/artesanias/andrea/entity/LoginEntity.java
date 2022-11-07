/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artesanias.andrea.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Alejandra.Agudelo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Login")
public class LoginEntity {
    
    @Id
    private Integer id;
    private String emailUser;
    private String passwordUser;
    
    
}
