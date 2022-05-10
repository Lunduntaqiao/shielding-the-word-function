package com.cpt202.xunwu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WordInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wordId;
    private String word;
    
    public long getWordId() {
        return wordId;
    }
    public void setWordId(long wordId) {
        this.wordId = wordId;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

}
