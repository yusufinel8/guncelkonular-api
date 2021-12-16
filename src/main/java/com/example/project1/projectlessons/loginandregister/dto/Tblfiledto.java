package com.example.project1.projectlessons.loginandregister.dto;

import com.example.project1.projectlessons.loginandregister.entity.Tblfileentity;
import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Tblfiledto implements Serializable {

    private Long tbl_id;
    private String tbl_file_path;
    private Date tbl_file_date;
    private String tbl_file_name;

    public Tblfiledto() {

    }
    public Tblfiledto(Builder builder) {

        this.tbl_file_date = builder.tbl_file_date;
        this.tbl_file_name = builder.tbl_file_name;
        this.tbl_id = builder.tbl_id;
        this.tbl_file_path = builder.tbl_file_path;
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

        private Long tbl_id;
        private String tbl_file_path;
        private Date tbl_file_date;
        private String tbl_file_name;
        public Builder() {
        }

        public static Builder userWith() {
            return new Tblfiledto.Builder();
        }

        public Builder tbl_id(final Long tbl_id) {
            this.tbl_id = tbl_id;
            return this;
        }

        public Builder tbl_file_path(final String tbl_file_path) {
            this.tbl_file_path = tbl_file_path;
            return this;
        }

        public Builder tbl_file_date(final Date tbl_file_date) {
            this.tbl_file_date = tbl_file_date;
            return this;
        }

        public Builder tbl_file_name(final String tbl_file_name) {
            this.tbl_file_name = tbl_file_name;
            return this;
        }

        public Tblfiledto build() {
            return new Tblfiledto(this);
        }

        public Tblfileentity convertToentity(Tblfiledto tblfiledto) {
            Tblfileentity tblfileentity = new Tblfileentity();
            tblfileentity.setTbl_file_date(tblfiledto.getTbl_file_date());
            tblfileentity.setTbl_id(tblfiledto.getTbl_id());
            tblfileentity.setTbl_file_name(tblfiledto.getTbl_file_name());
            tblfileentity.setTbl_file_path(tblfiledto.getTbl_file_path());
            return tblfileentity;
        }


    }

}
