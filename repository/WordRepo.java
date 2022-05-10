package com.cpt202.xunwu.repository;


import java.util.List;

import com.cpt202.xunwu.model.WordInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<WordInfo, Integer>{
    
    WordInfo findWordByWord(String Word);


}