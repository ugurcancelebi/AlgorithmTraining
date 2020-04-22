package com.example.socialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Bundle bundle = new Bundle();
        switch (item.getItemId()){
            case R.id.navigation_headlines:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,feedFragment)
                        .commit();
                return true;
            case R.id.navigation_saved:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,messageFragment)
                        .commit();
                return true;
            case R.id.navigation_sources:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,profileFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
