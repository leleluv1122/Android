package com.example.zlele;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
                }  else if (buttonId == R.id.btn_tt) {
                    Intent intent = new Intent(getApplicationContext(), TimetableActivity.class);
                    startActivity(intent);
                }
            }
        };
        Button info = (Button)findViewById(R.id.btn_proinfo);
        Button board = (Button)findViewById(R.id.btn_borad);
        Button tt = (Button)findViewById(R.id.btn_tt);

        info.setOnClickListener(listener);
        board.setOnClickListener(listener);
        tt.setOnClickListener(listener);
    }
}
