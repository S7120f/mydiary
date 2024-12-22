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
        // Hämta alla inlägg där datumet är idag eller tidigare
        Iterable<Diary> allDiaries = diaryRepository.findByDateBeforeOrDateEquals(LocalDate.now(), LocalDate.now());
        model.addAttribute("allPosts", allDiaries);
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

    @GetMapping("/filter-posts")
    public String filterPost(Model model, @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        Iterable<Diary> filteredDiaries = diaryRepository.findByDateBetween(startDate, endDate);
        model.addAttribute("allPosts", filteredDiaries);
        return "all-posts";
    }

}
