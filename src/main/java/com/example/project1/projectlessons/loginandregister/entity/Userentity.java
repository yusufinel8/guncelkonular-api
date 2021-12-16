package com.example.project1.projectlessons.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class Userentity implements Serializable {

    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long users_id;


    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String pasword;

    //@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Tblfileentity.class,mappedBy = "user")
    //@JsonIgnore,


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Tblfileentity> files;




}
