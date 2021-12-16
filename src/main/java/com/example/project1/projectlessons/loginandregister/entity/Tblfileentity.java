package com.example.project1.projectlessons.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_file")
public class Tblfileentity {

    @Id
    @Column(name = "tbl_id")
    private Long tbl_id;

    @Column(name = "tbl_file_path")
    private String tbl_file_path;

    @Column(name = "tbl_file_date")
    private Date tbl_file_date;

    @Column(name = "tbl_file_name")
    private String tbl_file_name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Userentity userentity;







}
