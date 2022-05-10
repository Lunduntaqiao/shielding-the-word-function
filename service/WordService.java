package com.cpt202.xunwu.service;

import java.util.List;

import com.cpt202.xunwu.bean.ComResult;
import com.cpt202.xunwu.model.WordInfo;
import com.cpt202.xunwu.repository.WordRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private WordRepo wordRepo;

    public ComResult SaveWord(WordInfo wordInfo) {
        ComResult comResult = new ComResult();

        try {
            String needSaveWord = wordInfo.getWord();
            WordInfo existWord = wordRepo.findWordByWord(needSaveWord);
            if (existWord != null)
                comResult.setMessage("该屏蔽词已存在!");
            else {
                wordRepo.save(wordInfo);
                comResult.setMessage("该屏蔽词已收录!");
            }
        } catch (Exception e) {
            comResult.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return comResult;
    }

    // check send messgae (if have masked word change to *)
    public ComResult checkMessage(String message) {
        ComResult comResult = new ComResult();
        try {
            String changed_massge = CheckWordHelper(message, wordRepo);
            comResult.setMessage(changed_massge.toString() + "   (违禁词已屏蔽!)");
        } catch (Exception e) {
            comResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return comResult;
    }

    // use to change all message that need to save in database
    public static String CheckWordHelper(String message, WordRepo wordRepo) {
        StringBuffer change_message = new StringBuffer(message);
        List<WordInfo> word_list = wordRepo.findAll();
        String replacemessage = message.replace(" ", "");
        for (int i = 0; i < word_list.size(); i++) {
            String save_word = word_list.get(i).getWord();
            if (replacemessage.contains(save_word)) {
                // find all masked word index in message
                for (int j = 0; j < save_word.length(); j++) {
                    int change_where = message.indexOf(save_word.charAt(j));
                    change_message.replace(change_where, change_where + 1, "*");
                }
            }
        }
        return change_message.toString();
    }
}
