package com.example.project1.projectlessons.login.repository;

import com.example.project1.projectlessons.login.entity.Tblfileentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tblfilerepository extends JpaRepository<Tblfileentity,Long>, CrudRepository<Tblfileentity,Long>, JpaSpecificationExecutor<Tblfileentity> {
}
