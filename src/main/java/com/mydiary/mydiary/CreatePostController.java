package com.mydiary.mydiary;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CreatePostController {
    
    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/new-post")
    public String newPost(Model model){

        // model.addAttribute("allPosts", diaryRepository.findAll());

        return"new-post";
    }

    @PostMapping("create-post")
    public String addNewPost(@RequestParam("title") String titleName, @RequestParam("content") String contentName, @RequestParam("dateNow") LocalDate dateName ){


        System.out.println("Nytt inlägg från forumet " + titleName + " " + dateName + " " + contentName);
        Diary diary = new Diary();
        diary.setTitle(titleName);
        diary.setContent(contentName);
        diary.setDate(dateName);
        diaryRepository.save(diary);


        return "redirect:/new-post";
    }

}
