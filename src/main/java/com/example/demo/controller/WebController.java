package com.example.demo.controller;

import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class WebController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String index() {
        return "index";

    }

    @GetMapping("/member")
    public String member(Model model) {
        model.addAttribute("title", "안녕");
        return "member";
    }

}
