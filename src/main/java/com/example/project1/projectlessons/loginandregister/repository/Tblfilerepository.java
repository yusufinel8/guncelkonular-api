package com.example.project1.projectlessons.loginandregister.repository;

import com.example.project1.projectlessons.loginandregister.entity.Tblfileentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tblfilerepository extends JpaRepository<Tblfileentity,Long>, CrudRepository<Tblfileentity,Long>, JpaSpecificationExecutor<Tblfileentity> {

    @Query(value = "Select * from tbl_file tb where tb.users_id=?1",nativeQuery = true)
    List<Tblfileentity> getFile(@Param("1") int id);


}
