package com.example.socialapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.socialapp.R;
import com.example.socialapp.databinding.FragmentFeedBinding;
import com.example.socialapp.databinding.FragmentProfileBinding;

public class FeedFragment extends Fragment {
    private FragmentFeedBinding fragmentFeedBinding;
    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.fragmentFeedBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_feed, container, false);


        return this.fragmentFeedBinding.getRoot();
    }
}
