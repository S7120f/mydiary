package com.mydiary.mydiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/all-posts")
    public String allPosts(Model model){

        model.addAttribute("allPosts", diaryRepository.findAll());


        return "all-posts";
    }

}
