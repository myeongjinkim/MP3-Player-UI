package com.example.hw_3.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private String lyrics=null;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public String getLyrics(){
        lyrics="\"1. 동해물과 백두산이 마르고 닳도록\n" +
                "하느님이 보우하사 우리나라 만세\n" +
                "무궁화 삼천리 화려 강산\n" +
                "대한 사람 대한으로 길이 보전하세\n" +
                "\n" +
                "2. 남산 위에 저 소나무 철갑을 두른 듯\n" +
                "바람 서리 불변함은 우리 기상일세\n" +
                "무궁화 삼천리 화려 강산\n" +
                "대한 사람 대한으로 길이 보전하세\n" +
                "\n" +
                "3. 가을 하늘 공활한데 높고 구름 없이\n" +
                "밝은 달은 우리 가슴 일편단심일세\n" +
                "무궁화 삼천리 화려 강산\n" +
                "대한 사람 대한으로 길이 보전하세\n" +
                "\n" +
                "4. 이 기상과 이 맘으로 충성을 다하여\n" +
                "괴로우나 즐거우나 나라 사랑하세\n" +
                "무궁화 삼천리 화려 강산\n" +
                "대한 사람 대한으로 길이 보전하세\n" +
                "\"";
        return lyrics;
    }
    private void getText(){
        mText.setValue(lyrics);
    }
}