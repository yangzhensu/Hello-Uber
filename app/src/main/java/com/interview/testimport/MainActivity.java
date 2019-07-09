package com.interview.testimport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachNewsListFragment();
    }

    private void attachNewsListFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.activity_main_root) == null) {
            fm.beginTransaction()
                    .replace(R.id.activity_main_root, NewsListFragment.newInstance())
                    .commit();
        }
    }
}
