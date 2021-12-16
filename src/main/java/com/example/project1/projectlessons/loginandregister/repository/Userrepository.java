package com.example.project1.projectlessons.login.repository;

import com.example.project1.projectlessons.login.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepository extends JpaRepository<Userentity,Long>,JpaSpecificationExecutor<Userentity>,CrudRepository<Userentity,Long>,PagingAndSortingRepository<Userentity,Long> {

    @Query(value = "Select * from users t where t.email=?1 and t.password=?2",nativeQuery = true)
     Userentity login(@Param("1") String email, @Param("2") String password);




}
