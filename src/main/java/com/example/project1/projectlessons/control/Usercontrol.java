package com.example.project1.projectlessons.control;


import com.example.project1.projectlessons.entity.deneme;
import com.example.project1.projectlessons.repository.denemerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontrol {
    private denemerepo dnmrepo;

    @Autowired
    public Usercontrol(denemerepo dnmrepo){
        this.dnmrepo=dnmrepo;
    }



    @PostMapping("/userlogin")
    public List<deneme> getir(){
        return dnmrepo.findAll();
    }


}
