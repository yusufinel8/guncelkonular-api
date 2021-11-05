package com.example.project1.projectlessons.dto;

import com.example.project1.projectlessons.entity.Userentity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Data
@Getter
@Setter
public class Userdto implements Serializable {
    
    private Long id;

    private String firstname;

    private String surname;

    private String email;

    private String user_level;

    private String dosya_id;


    public Userdto(){

    }

    public Userdto(Builder builder){
        this.id=builder.id;
        this.firstname=builder.firstname;
        this.surname=builder.surname;
        this.email=builder.email;
        this.user_level=builder.user_level;
        this.dosya_id=builder.dosya_id;
        

    }

    public static class Builder{

        private Long id;
        private String firstname;
        private String surname;
        private String email;
        private String user_level;
        private String dosya_id;

        public Builder(){

        }
        public static Builder userWith(){
            return new Builder();
        }
        public Builder id(final Long id){
            this.id=id;
            return this;
        }
        public Builder firstname(final String firstname){
            this.firstname=firstname;
            return this;
        }
        public Builder surname(final String surname){
            this.surname=surname;
            return this;
        }
        public Builder email(final String email){
            this.email=email;
            return this;
        }
        public Builder user_level(final String user_level){
            this.user_level=user_level;
            return this;
        }
        public Builder dosya_id(final String dosya_id){
            this.dosya_id=dosya_id;
            return this;
        }
        public Userdto build() {
            return new Userdto(this);
        }

        public Userentity convertToentity(Userdto userdto){
            Userentity userentity= new Userentity();
            userentity.setId(userdto.getId());
            userentity.setFirstname(userdto.getFirstname());
            userentity.setSurname(userdto.getSurname());
            userentity.setMail(userdto.getEmail());
            return userentity;

        }


    }

 
}
