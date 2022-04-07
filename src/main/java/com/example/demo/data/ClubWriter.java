package com.example.demo.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="clubwriter")
public class ClubWriter {
    @Id
    private String cwriter_code;

    @Column()
    private String ctitle;
    private String ccontent;

    public String getCwriter_code() {
        return cwriter_code;
    }

    public void setCwriter_code(String cwriter_code) {
        this.cwriter_code = cwriter_code;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }
}
