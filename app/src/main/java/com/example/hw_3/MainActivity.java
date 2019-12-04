package com.example.hw_3;

import android.net.Uri;
import android.os.Bundle;

import com.example.hw_3.ui.home.HomeViewModel;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.util.Log;
import android.view.Menu;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import java.io.File;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;




public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private String lyrics;
    private String title;
    private String artist;

    private File fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeViewModel model= ViewModelProviders.of(this).get(HomeViewModel.class);
        music();
        System.out.println(title);
        System.out.println(artist);
        System.out.println(lyrics);
        model.setLyricsText(lyrics);
        model.setTitle(title);
        model.setArtist(artist);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void music(){
        /*/data/data/com.example.hw_3/files/dont_look_back_in_anger.mp3

        getResources().openRawResource(R.raw.dont_look_back_in_anger);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dont_look_back_in_anger);*/
        fs = new File("/data/data/com.example.hw_3/music/starlight.mp3");

        if(fs.isFile()){
            System.out.println("들어감");
            String decoding = "ISO-8859-1";
            String encoding = "EUC-KR";


            //File list[] = fs.listFiles();
            //for(File f : list){
                try{
                    MP3File mp3 = (MP3File) AudioFileIO.read(fs);
                    AbstractID3v2Tag tag2 = mp3.getID3v2Tag();

                    Tag tag = mp3.getTag();
                    title = tag.getFirst(FieldKey.TITLE);
                    artist = tag.getFirst(FieldKey.ARTIST);
                    lyrics = tag.getFirst(FieldKey.LYRICS);


                }catch(Exception ex){
                    ex.printStackTrace();
                }
            //}
        }
        else {
            System.out.println("경로 틀림");
        }
    }

}
