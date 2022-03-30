package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="member")
public class Member {
    @Id
    private String member_code;
    @Column
    private String member_id;
    @Column
    private String member_pw;
    @Column
    private String member_email;
    @Column
    private String member_nn;
    @Column
    private String member_name;

    public String getMember_code() {
        return member_code;
    }


    public void setMember_code(String member_code) {
        this.member_code = member_code;
    }
}
