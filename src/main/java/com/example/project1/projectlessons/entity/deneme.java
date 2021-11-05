package com.example.project1.projectlessons.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deneme")
public class deneme {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "kullanici_adi")
    private String kullanici_adi;

    @Column(name="sifre")
    private String sifre;



}
