package com.example.zlele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String msg;
                int buttonId = view.getId();
                if (buttonId == R.id.btn_proinfo) {
                    Intent intent = new Intent(getApplicationContext(), TeacherInfoActivity.class);
                    startActivity(intent);
                } else if (buttonId == R.id.btn_borad) {
                    Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                    startActivity(intent);
                }
            }
        };
        Button info = (Button)findViewById(R.id.btn_proinfo);
        Button board = (Button)findViewById(R.id.btn_borad);

        info.setOnClickListener(listener);
        board.setOnClickListener(listener);
    }
}
