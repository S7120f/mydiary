package com.mydiary.mydiary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {
    

    @GetMapping("/all-posts")
    public String allPosts(){

        return "all-posts";
    }
}
