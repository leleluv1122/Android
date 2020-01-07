package com.example.parsing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(R.id.tab_host);
        tabHost.setup();

        // Tab1 Setting
        TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        tabSpec1.setIndicator("홈"); // Tab Subject
        tabSpec1.setContent(R.id.tab1); // Tab Content
        tabHost.addTab(tabSpec1);

        // Tab2 Setting
        TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("메뉴"); // Tab Subject
        tabSpec2.setContent(R.id.tab2); // Tab Content
        tabHost.addTab(tabSpec2);
        tabHost.setCurrentTab(0);

    }

}