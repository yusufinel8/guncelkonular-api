package com.example.project1.projectlessons.loginandregister.mapper;

import com.example.project1.projectlessons.loginandregister.dto.Tblfiledto;
import com.example.project1.projectlessons.loginandregister.entity.Tblfileentity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tblfilemapper {

    public Tblfiledto map(Tblfileentity tblfileentity){
        return Tblfiledto.Builder.userWith()
                .tbl_id(tblfileentity.getTbl_id())
                .tbl_file_name(tblfileentity.getTbl_file_name())
                .tbl_file_path(tblfileentity.getTbl_file_path())
                .tbl_file_date(tblfileentity.getTbl_file_date())
                .build();
    }
    public List<Tblfiledto>  mapList(List<Tblfileentity> tblfileentities){
        List<Tblfiledto> maplist=new ArrayList<>();
        for(Tblfileentity tblfileentity : tblfileentities){
            maplist.add(this.map(tblfileentity));
        }
        return maplist;
    }
}
