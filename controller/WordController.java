package com.cpt202.xunwu.controller;

import javax.servlet.http.HttpSession;

import com.cpt202.xunwu.bean.ComResult;
import com.cpt202.xunwu.model.WordInfo;
import com.cpt202.xunwu.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping(value="CheckMessage")
    public ComResult CheckMessage(@RequestParam(name = "Message") String message) {
        //TODO: process POST request
        
        return wordService.checkMessage(message);
    }

    @PostMapping(value="SaveMaskedWord")
    public ComResult SaveMaskedWord(@RequestBody WordInfo wordInfo) {
        //TODO: process POST request
        
        return wordService.SaveWord(wordInfo);
    }
    
}
