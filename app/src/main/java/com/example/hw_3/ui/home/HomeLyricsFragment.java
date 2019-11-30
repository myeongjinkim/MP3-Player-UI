package com.example.hw_3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hw_3.R;
import com.example.hw_3.databinding.FragmentHomeLyricsBinding;

public class HomeLyricsFragment extends Fragment {
    private TextView lyricsTextView;
    private HomeViewModel homeViewModel;
    public FragmentHomeLyricsBinding binding;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_lyrics, container, false);
        lyricsTextView = rootView.findViewById(R.id.lyric);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        homeViewModel.getLyrics().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                lyricsTextView.setText(s);
            }
        });

        binding = DataBindingUtil.bind(rootView);
        binding.setFragment(this);
        return rootView;
    }
    public void presslyrics(View view){
        /*if(this.lyricsTextView.getText().equals("")){
            this.lyricsTextView.setText(homeViewModel.getLyrics().toString());
        }else{
            this.lyricsTextView.setText("");
            homeViewModel.setAlbum();//앨범자켓 설정
        }*/
    }
}
