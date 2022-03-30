package com.example.demo.data;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@Table(name="writer")
public class Writer {
    @Id
    private String writer_code;

    @Column()
    private String title;
    private String content;

    public String getWriter_code() {
        return writer_code;
    }

    public void setWriter_code(String writer_code) {
        this.writer_code = writer_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

