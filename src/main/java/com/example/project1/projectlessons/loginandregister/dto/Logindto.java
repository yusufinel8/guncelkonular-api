package com.example.project1.projectlessons.loginandregister.dto;

import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
@Getter
@Setter
@Data
public class Logindto implements Serializable {
    private String email;

    private String password;

    private int code;

    public Logindto(){

    }

    public Logindto(Builder builder){
        this.email=builder.email;
        this.password=builder.password;
        this.code=builder.code;
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

        private String email;

        private String password;

        private int code;

        public Builder(){

        }

        public static Builder userWith(){
            return new Builder();
        }

        public Builder email(final String email){
            this.email=email;
            return this;
        }
        public Builder password(final String password){
            this.password=password;
            return this;
        }
        public Builder code(final int code){
            this.code=code;
            return this;
        }

        public Logindto build() {
            return new Logindto(this);
        }

        public Userentity convertToentity(Logindto logindto){
            Userentity userentity=new Userentity();
            userentity.setEmail(logindto.getEmail());
            userentity.setPasword(logindto.getPassword());
            return userentity;
        }

    }
}
