package com.mydiary.mydiary;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostsController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/all-posts")
    public String allPosts(Model model) {

        model.addAttribute("allPosts", diaryRepository.findAll());

        return "all-posts";
    }

    @GetMapping("/update-post")
    public String updatePost(Model model, @RequestParam int id) {
        Diary diary = diaryRepository.findById(id).orElse(null);
        if (diary != null) {
            model.addAttribute("diary", diary);
            return "post-update";

        }

        return "redirect:/all-posts";

    }

    @PostMapping("/update-post")
    public String saveUpdatedPost(Diary diary) {
        diaryRepository.save(diary);
        return "redirect:/all-posts";
    }

}
