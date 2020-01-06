package com.example.zlele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String msg;
                int buttonId = view.getId();
                if(buttonId == R.id.btn_Attend) {
                    Intent intent = new Intent(getApplicationContext(), AttendActivity.class);
                    startActivity(intent);
                } else if(buttonId == R.id.btn_Score) {
                    Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                    startActivity(intent);
                } else if(buttonId == R.id.btn_Info){
                    Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                    startActivity(intent);
                }

            }
        };
        Button attend = (Button)findViewById(R.id.btn_Attend);
        Button score = (Button)findViewById(R.id.btn_Score);
        Button info = (Button)findViewById(R.id.btn_Info);
        attend.setOnClickListener(listener);
        score.setOnClickListener(listener);
        info.setOnClickListener(listener);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            Toast.makeText(this, "My page Gogogo", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_attend) {
            Toast.makeText(this, "출결정보 gogogo", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_score) {
            Toast.makeText(this, "이수학점고고공", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_teacher_info) {
            Toast.makeText(this, "교수정보 ㄱㄱ", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
