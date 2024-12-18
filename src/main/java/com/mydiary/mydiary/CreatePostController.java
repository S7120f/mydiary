package com.mydiary.mydiary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatePostController {
    

    @GetMapping("/new-post")
    public String newPost(){

        return"new-post";
    }

}
