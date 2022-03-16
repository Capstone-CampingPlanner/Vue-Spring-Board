package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class member {
    @Id
    private String member_code;
    private String member_id;
    private String member_pw;
    private String member_email;
    private String member_nn;
    private String member_name;

    public String getMember_code() {
        return member_code;
    }

    public void setMember_code(String member_code) {
        this.member_code = member_code;
    }
}
