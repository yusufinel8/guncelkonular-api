package com.example.project1.projectlessons.service.userserviceimpl;

import com.example.project1.projectlessons.repository.Userrepository;
import com.example.project1.projectlessons.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service

public class Userserviceimpl implements Userservice{

    private final Userrepository userrepository;

    @Autowired
    public Userserviceimpl(Userrepository userrepository){
        this.userrepository=userrepository;
    }

 

    @Override
    public void deleteById(Long id) {
        userrepository.deleteById(id);       
    }
     
}
