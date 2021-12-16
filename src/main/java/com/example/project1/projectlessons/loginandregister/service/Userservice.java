package com.example.project1.projectlessons.login.service;

import com.example.project1.projectlessons.login.dto.Logindto;
import com.example.project1.projectlessons.login.dto.RegisterDto;
import com.example.project1.projectlessons.login.dto.Userdto;
import com.example.project1.projectlessons.login.entity.Userentity;
import org.apache.catalina.User;

public interface Userservice {
    
     Logindto login(Logindto logindto);
     RegisterDto register(RegisterDto registerDto);

}
