package com.example.project1.projectlessons.login.dto;

import com.example.project1.projectlessons.login.entity.Tblfileentity;
import com.example.project1.projectlessons.login.entity.Userentity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Userdto implements Serializable {
    
    private Long user_id;

    private String user_name;

    private String email;

    private String password;

    public Userdto(){

    }

    public Userdto(Builder builder){
        this.user_id=builder.id;
        this.user_name=builder.user_name;
        this.email=builder.email;
        this.password=builder.password;

    }
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    public static class Builder{

        private Long id;
        private String user_name;
        private String email;
        private String password;

        public Builder(){

        }
        public static Builder userWith(){
            return new Builder();
        }
        //id set etme
        public Builder id(final Long id){
            this.id=id;
            return this;
        }
        //username set etme
        public Builder user_name(final String user_name){
            this.user_name=user_name;
            return this;
        }
        //password set etme
        public Builder password(final String password){
            this.password=password;
            return this;
        }
        // email set etme
        public Builder email(final String email){
            this.email=email;
            return this;
        }

        public Userdto build() {
            return new Userdto(this);
        }

        public Userentity convertToentity(Userdto userdto){
            Userentity userentity= new Userentity();
            userentity.setUsers_id(userdto.getUser_id());
            userentity.setUser_name(userdto.getUser_name());
            userentity.setEmail(userdto.getEmail());
            userentity.setPasword(userdto.getPassword());
            return userentity;

        }


    }

 
}
