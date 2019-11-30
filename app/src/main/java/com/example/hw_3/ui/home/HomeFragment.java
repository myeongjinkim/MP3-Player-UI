package com.example.hw_3.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class HomeFragment extends Fragment {

    private FragmentTransaction ft;
    private HomeViewModel homeViewModel;
    public FragmentHomeBinding binding;
    private HomeLyricsFragment homeLyricsFragment;
    private boolean start = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 전환 프래그먼트 선언 및 초기 화면 설정
        ft = getChildFragmentManager().beginTransaction();
        homeLyricsFragment = new HomeLyricsFragment();
    }
        public View onCreateView(@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        binding = DataBindingUtil.bind(rootView);
        binding.setFragment(this);
        return rootView;
    }
    public void replacec(){
        ft.addToBackStack(null);
        ft.replace(R.id.replace, homeLyricsFragment);
        ft.commit();
    }

}