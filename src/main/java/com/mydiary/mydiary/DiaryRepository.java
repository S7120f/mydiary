package com.mydiary.mydiary;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary, Integer> {
    
        // Hämta alla inläggg där datumet är idag eller tidigare 
        Iterable<Diary> findByDateBeforeOrDateEquals(LocalDate before, LocalDate equals);

        //Hämta alla inlkägg mellan två datum
        Iterable<Diary> findByDateBetween(LocalDate startDate, LocalDate endDate);

    
}
