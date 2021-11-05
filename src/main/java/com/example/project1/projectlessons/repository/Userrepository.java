package com.example.project1.projectlessons.repository;

import com.example.project1.projectlessons.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<Userentity,Long>,JpaSpecificationExecutor<Userentity>,CrudRepository<Userentity,Long>,PagingAndSortingRepository<Userentity,Long> {
    
}
