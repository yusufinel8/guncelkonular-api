package com.example.project1.projectlessons.loginandregister.service;

import com.example.project1.projectlessons.loginandregister.dto.Logindto;
import com.example.project1.projectlessons.loginandregister.dto.RegisterDto;
import com.example.project1.projectlessons.loginandregister.dto.Tblfiledto;

import java.util.List;

public interface Userservice {
    
     Logindto login(Logindto logindto);
     RegisterDto register(RegisterDto registerDto);
     List<Tblfiledto> getFileservice(int id);

}
