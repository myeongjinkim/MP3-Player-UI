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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hw_3.R;
import com.example.hw_3.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public FragmentHomeBinding binding;
    private boolean start = false;
    private TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        public View onCreateView(@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        textView = rootView.findViewById(R.id.lyric);
        binding = DataBindingUtil.bind(rootView);
        binding.setFragment(this);
        return rootView;
    }
    public void presslyrics(View view){
        System.out.println(this.textView.getText());
        System.out.println("출력");
        this.textView.setText("change2");
        System.out.println(this.textView.getText());
    }
}