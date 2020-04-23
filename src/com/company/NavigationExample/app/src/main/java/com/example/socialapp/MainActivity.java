package com.example.socialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.socialapp.databinding.ActivityMainBinding;
import com.example.socialapp.fragment.FeedFragment;
import com.example.socialapp.fragment.MessageFragment;
import com.example.socialapp.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private ActivityMainBinding activityMainBinding;
    private FeedFragment feedFragment;
    private ProfileFragment profileFragment;
    private MessageFragment messageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.navigation.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState == null){
            feedFragment = FeedFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, feedFragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_headlines:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,feedFragment)
                        .commit();
                return true;
            case R.id.navigation_saved:
                if (messageFragment == null){
                    messageFragment = MessageFragment.newInstance();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,messageFragment)
                        .commit();
                return true;
            case R.id.navigation_sources:
                if (profileFragment == null){
                    profileFragment = ProfileFragment.newInstance();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,profileFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
