package com.mydiary.mydiary;

import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary, Integer> {
    
}
