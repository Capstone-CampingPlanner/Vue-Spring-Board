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

    @GetMapping("myList/{writer_code}")
    public Optional<Writer> myList(@PathVariable("writer_code") String writer_code) {
        System.out.println("Vue에서 받은 데이터는" + writer_code + " 입니다.");

        Optional<Writer> myMyList = writerRepository.findById(writer_code);
        return myMyList;
    }

    @DeleteMapping("deleteList/{writer_code}")
    public String deleteList(@PathVariable("writer_code") String writer_code) {
        System.out.println("삭제할 게시글 번호는 : " +writer_code);
        Optional<Writer> writer = writerRepository.findById(writer_code);
        writerRepository.deleteById(writer_code);
        return "게시글이 삭제되었습니다.";


    }

    @PutMapping("update/{writer_code}")
    public String updateList(@RequestBody Writer writer, @PathVariable("writer_code") String writer_code) {
        writerRepository.findById(writer_code);
        return writer_code;
    }


}



