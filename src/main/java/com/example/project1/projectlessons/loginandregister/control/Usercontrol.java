package com.example.project1.projectlessons.loginandregister.control;


import com.example.project1.projectlessons.loginandregister.dto.Logindto;
import com.example.project1.projectlessons.loginandregister.dto.RegisterDto;
import com.example.project1.projectlessons.loginandregister.dto.Tblfiledto;
import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import com.example.project1.projectlessons.loginandregister.repository.Userrepository;
import com.example.project1.projectlessons.loginandregister.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class Usercontrol {

    private final Userrepository userrepository;
    private final Userservice userservice;

    @Autowired
    public Usercontrol(Userrepository userrepository, Userservice userservice) {
        this.userservice = userservice;
        this.userrepository = userrepository;
    }

    @GetMapping("/login/{id}")
    public String come(@PathVariable("id") String id) {
        return " id : " + id;
    }


    //Login
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Logindto login(@RequestBody Logindto logindto) {
        return userservice.login(logindto);
    }

    //Register
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RegisterDto register(@RequestBody RegisterDto registerDto) {
        return userservice.register(registerDto);
    }

    @PostMapping("/all")
    public List<Userentity> userentity() {
        return userrepository.findAll();
    }

    @GetMapping("/homepage/{id}")
    public List<Tblfiledto> getFile(@PathVariable("id") int id) {
        return userservice.getFileservice(id);
    }

    //delete user
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userrepository.deleteById(id);
    }


}
