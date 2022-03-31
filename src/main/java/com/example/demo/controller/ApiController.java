package com.example.demo.controller;

import com.example.demo.data.Writer;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.WriterRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private WriterRepository writerRepository;

//    @GetMapping("/board")
//    public List board(){
//        List posts = postRepository.findAll();
//        return posts;
//    }

    @PostMapping("signup")
    @JsonProperty("writer")
    public Writer addWriter(@RequestBody Writer writer) {
        System.out.println(writer.getWriter_code());
        writerRepository.save(writer);
        return writer;
    }

    @GetMapping("list")
    public List<Writer> writerMyList() {
        List<Writer> writerList = writerRepository.findAll();
        System.out.println(writerList);
        return writerList;
    }
}



