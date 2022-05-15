/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eder_Crespo
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {

    @Id
    private long id;
    private String name;
    private int age; 
    
}
