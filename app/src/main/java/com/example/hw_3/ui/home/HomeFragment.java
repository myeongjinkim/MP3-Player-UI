package com.example.hw_3.ui.home;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hw_3.R;
import com.example.hw_3.databinding.FragmentHomeBinding;

import java.io.IOException;

public class HomeFragment extends Fragment {

    //ui 및 구조
    private HomeViewModel homeViewModel;
    private FragmentTransaction ft;
    public FragmentHomeBinding binding;
    private HomeLyricsFragment homeLyricsFragment;
    private HomeJacketFragment homeJacketFragment;
    private boolean start = false;
    private boolean check =true;

    //mp3
    private MediaPlayer mediaPlayer;
    SeekBar seekbar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 전환 프래그먼트 선언 및 초기 화면 설정
        homeLyricsFragment = new HomeLyricsFragment();
        homeJacketFragment = new HomeJacketFragment();



    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dont_look_back_in_anger);
        seekbar = (SeekBar)rootView.findViewById(R.id.seekBar);
        seekbar.setMax(mediaPlayer.getDuration());



        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                if(fromUser)
                    mediaPlayer.seekTo(progress);
            }
        });




        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        if( homeViewModel.getCheck()){
            replaceToJacket();
        }else{
            replaceToLyrics();
        }
        homeViewModel.LyricsSetting();

        binding = DataBindingUtil.bind(rootView);
        binding.setFragment(this);
        return rootView;
    }

    public void replaceToJacket(){
        ft = getChildFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.replace, homeJacketFragment);
        ft.commit();
    }
    public void replaceToLyrics(){
        ft = getChildFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.replace, homeLyricsFragment);
        ft.commit();
    }
    public void pressPlay(View v){
        if(mediaPlayer.isPlaying()){
            System.out.println("멈춤");
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.seekTo(0);
            seekbar.setProgress(0);
        }else {
            mediaPlayer.start();
            System.out.println("실행");

            //Thread();
        }
    }
}