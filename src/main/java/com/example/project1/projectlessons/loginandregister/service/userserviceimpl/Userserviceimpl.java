package com.example.project1.projectlessons.loginandregister.service.userserviceimpl;

import com.example.project1.projectlessons.loginandregister.bean.EmailVerification;
import com.example.project1.projectlessons.loginandregister.dto.Logindto;
import com.example.project1.projectlessons.loginandregister.dto.RegisterDto;
import com.example.project1.projectlessons.loginandregister.dto.Tblfiledto;
import com.example.project1.projectlessons.loginandregister.entity.Tblfileentity;
import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import com.example.project1.projectlessons.loginandregister.mapper.LoginDtoMapper;
import com.example.project1.projectlessons.loginandregister.mapper.RegisterDtoMapper;
import com.example.project1.projectlessons.loginandregister.mapper.Tblfilemapper;
import com.example.project1.projectlessons.loginandregister.repository.Tblfilerepository;
import com.example.project1.projectlessons.loginandregister.repository.Userrepository;
import com.example.project1.projectlessons.loginandregister.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userserviceimpl implements Userservice {

    private final Userrepository userrepository;

    private final LoginDtoMapper loginmapper;

    private final Tblfilemapper tblfilemapper;

    private final RegisterDtoMapper registerDtoMapper;

    private final EmailVerification emailVerification;

    private final Tblfilerepository tblfilerepository;

    @Autowired
    public Userserviceimpl(LoginDtoMapper mapper, Userrepository userrepository
            , RegisterDtoMapper registerDtoMapper, EmailVerification emailVerification
            , Tblfilemapper tblfilemapper,Tblfilerepository tblfilerepository) {
        this.userrepository = userrepository;
        this.loginmapper = mapper;
        this.registerDtoMapper = registerDtoMapper;
        this.emailVerification = emailVerification;
        this.tblfilemapper=tblfilemapper;
        this.tblfilerepository=tblfilerepository;
    }


    @Override
    // @EventListener(ApplicationReadyEvent.class)
    public Logindto login(Logindto logindto) {
        Userentity userentity1 = userrepository.login(logindto.getEmail(), logindto.getPassword());
        Optional<Userentity> user = Optional.ofNullable(userentity1);
        if (user.isPresent()) {
            int code = emailVerification.sendSimpleEmail(logindto.getEmail());
            Logindto login = loginmapper.map(userentity1, code);
            return login;
        } else
            return null;
    }

    @Override
    public RegisterDto register(RegisterDto registerDto) {
        Userentity userentity = RegisterDto.Builder.userWith().convertToentity(registerDto);
        Userentity userentity1 = userrepository.save(userentity);
        RegisterDto register = registerDtoMapper.map(userentity1);
        return register;
    }

    @Override
    public List<Tblfiledto> getFileservice(int id) {
        List<Tblfileentity> tblfileentity = tblfilerepository.getFile(id);
        List<Tblfiledto> tblfiledto =tblfilemapper.mapList(tblfileentity);
        return tblfiledto;
    }


}
