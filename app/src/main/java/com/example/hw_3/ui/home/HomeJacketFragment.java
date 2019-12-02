package com.example.hw_3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hw_3.R;
import com.example.hw_3.databinding.FragmentHomeJacketBinding;

public class HomeJacketFragment  extends Fragment {
    private TextView lyricsTextView;
    private HomeViewModel homeViewModel;
    public FragmentHomeJacketBinding binding;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_jacket, container, false);
        lyricsTextView = rootView.findViewById(R.id.Jacket);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

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
    public void pressJacket(View view){
        homeViewModel.LyricsSetting();
    }

}
