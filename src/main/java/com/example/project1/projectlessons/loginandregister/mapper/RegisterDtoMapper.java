package com.example.project1.projectlessons.login.mapper;

import com.example.project1.projectlessons.login.dto.Logindto;
import com.example.project1.projectlessons.login.dto.RegisterDto;
import com.example.project1.projectlessons.login.dto.Userdto;
import com.example.project1.projectlessons.login.entity.Userentity;
import org.springframework.stereotype.Component;

@Component
public class RegisterDtoMapper {

    public RegisterDto map(Userentity userentity){

        return RegisterDto.Builder.userWith().user_name(userentity.getUser_name())
                .password(userentity.getPasword()).email(userentity.getEmail()).build();
    }

    public Userentity convertToentity(RegisterDto registerDto){
        return RegisterDto.Builder.userWith().convertToentity(registerDto);
    }



}
