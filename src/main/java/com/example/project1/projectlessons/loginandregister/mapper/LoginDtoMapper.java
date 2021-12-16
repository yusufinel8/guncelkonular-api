package com.example.project1.projectlessons.login.mapper;

import com.example.project1.projectlessons.login.bean.EmailVerification;
import com.example.project1.projectlessons.login.dto.Logindto;
import com.example.project1.projectlessons.login.entity.Userentity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDtoMapper {
    private final EmailVerification emailVerification;

    @Autowired
    public LoginDtoMapper(EmailVerification emailVerification) {
        this.emailVerification = emailVerification;
    }



    //Entity classlarını Dtoya çevirir
    public Logindto map(Userentity userentity,int kod){
        return Logindto.Builder.userWith()
                .email(userentity.getEmail())
                .password(userentity.getPasword())
                .code(kod).build();
    }


    //Dto classlarını entity'e çevirir.
    public Userentity convertToentity(Logindto logindto){
        return Logindto.Builder.userWith().convertToentity(logindto);
    }

}
