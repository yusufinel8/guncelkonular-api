package com.example.project1.projectlessons.login.control;


import com.example.project1.projectlessons.login.dto.Logindto;
import com.example.project1.projectlessons.login.dto.RegisterDto;
import com.example.project1.projectlessons.login.entity.Userentity;
import com.example.project1.projectlessons.login.repository.Userrepository;
import com.example.project1.projectlessons.login.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //@GetMapping("/userlogin/{username}/{password}")
    //public List<Userentity> turn(@PathVariable("username") String username, @PathVariable("password") String password){
    //   return userrepository.getuser(username,password);
    //}


    //Login
    @PostMapping(value = "/login",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Logindto login(@RequestBody Logindto logindto) {
        return userservice.login(logindto);
    }

    //Register
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RegisterDto register(@RequestBody RegisterDto registerDto){
        return userservice.register(registerDto);
    }

    @PostMapping("/a")
    public List<Userentity> userentity(){
        return userrepository.findAll();
    }


}
