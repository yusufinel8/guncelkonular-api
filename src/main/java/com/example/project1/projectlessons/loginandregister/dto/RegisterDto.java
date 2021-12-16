package com.example.project1.projectlessons.loginandregister.dto;

import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Data
@Getter
@Setter
public class RegisterDto {

    private String user_name;

    private String email;

    private String password;

    public RegisterDto() {

    }

    public RegisterDto(Builder builder) {
        this.user_name = builder.user_name;
        this.email = builder.email;
        this.password = builder.password;

    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder {

        private String user_name;
        private String email;
        private String password;

        public Builder() {

        }

        public static Builder userWith() {
            return new Builder();
        }
        //id set etme

        //username set etme
        public Builder user_name(final String user_name) {
            this.user_name = user_name;
            return this;
        }

        //password set etme
        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        // email set etme
        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public RegisterDto build() {
            return new RegisterDto(this);
        }

        public Userentity convertToentity(RegisterDto registerDto) {
            Userentity userentity = new Userentity();
            userentity.setUser_name(registerDto.getUser_name());
            userentity.setEmail(registerDto.getEmail());
            userentity.setPasword(registerDto.getPassword());
            return userentity;

        }


    }


}
