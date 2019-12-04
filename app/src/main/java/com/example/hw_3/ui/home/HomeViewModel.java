package com.example.hw_3.ui.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> lyrics;
    //private MutableLiveData<String> title;
    //private MutableLiveData<String> artist;
    private Boolean check;
    private String lyricsText;
    private String title;
    private String artist;

    public HomeViewModel() {
        lyrics = new MutableLiveData<>();
        //title = new MutableLiveData<>();
        //artist = new MutableLiveData<>();
        lyrics.setValue("This is home fragment");
        check = true;
    }

    public Boolean getCheck(){
        return check;
    }
    public void setCheck(){
        if(check){
            check = false;
        }else{
            check=true;
        }
    }
    public LiveData<String> getLyrics(){
        if(lyrics.equals("")){
            LyricsSetting();
        }
        return lyrics;
    }
    public void LyricsSetting(){
        //가사 가져오는 부분
        lyrics.setValue(lyricsText);
    }
    public void setLyricsText(String text){
        lyricsText=text;
    }
    public void setAlbum(){ } // 앨범자켓 세팅하는 부분
    private void albumSetting(){ }//앨범자켓 가져오는 부분

    public void setTitle(String text){
        //title.setValue(text);
        title=text;
    }
    public void setArtist(String text){
        //artist.setValue(text);
        artist=text;
    }
    public String getTitle(){
        //return title.getValue();
        return title;
    }

    public String getArtist(){
        //return artist.getValue();
        return artist;
    }

}