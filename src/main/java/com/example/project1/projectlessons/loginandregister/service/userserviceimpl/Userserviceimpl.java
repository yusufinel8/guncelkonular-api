package com.example.project1.projectlessons.login.service.userserviceimpl;

import com.example.project1.projectlessons.login.bean.EmailVerification;
import com.example.project1.projectlessons.login.dto.Logindto;
import com.example.project1.projectlessons.login.dto.RegisterDto;
import com.example.project1.projectlessons.login.entity.Userentity;
import com.example.project1.projectlessons.login.mapper.LoginDtoMapper;
import com.example.project1.projectlessons.login.mapper.RegisterDtoMapper;
import com.example.project1.projectlessons.login.repository.Userrepository;
import com.example.project1.projectlessons.login.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userserviceimpl implements Userservice {

    private final Userrepository userrepository;

    private final LoginDtoMapper mapper;

    private final RegisterDtoMapper registerDtoMapper;

    private final EmailVerification emailVerification;

    @Autowired
    public Userserviceimpl(LoginDtoMapper mapper, Userrepository userrepository
            , RegisterDtoMapper registerDtoMapper, EmailVerification emailVerification) {
        this.userrepository = userrepository;
        this.mapper = mapper;
        this.registerDtoMapper = registerDtoMapper;
        this.emailVerification = emailVerification;
    }


    @Override
    // @EventListener(ApplicationReadyEvent.class)
    public Logindto login(Logindto logindto) {
        Userentity userentity1 = userrepository.login(logindto.getEmail(), logindto.getPassword());
        Optional<Userentity> user=Optional.ofNullable(userentity1);
        if(user.isPresent()){
            int code = emailVerification.sendSimpleEmail(logindto.getEmail());
            Logindto login = mapper.map(userentity1, code);
            return login;
        }
        else
            return null;
    }

    @Override
    public RegisterDto register(RegisterDto registerDto) {
        Userentity userentity = RegisterDto.Builder.userWith().convertToentity(registerDto);
        Userentity userentity1 = userrepository.save(userentity);
        RegisterDto register = registerDtoMapper.map(userentity1);
        return register;
    }


}
