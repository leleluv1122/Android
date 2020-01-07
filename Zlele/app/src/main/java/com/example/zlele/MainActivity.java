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
                }  else if(buttonId == R.id.btn_menu){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }

            }
        };
        Button attend = (Button)findViewById(R.id.btn_Attend);
        Button score = (Button)findViewById(R.id.btn_Score);
        Button info = (Button)findViewById(R.id.btn_Info);
        ImageButton menu = (ImageButton) findViewById(R.id.btn_menu);

        attend.setOnClickListener(listener);
        score.setOnClickListener(listener);
        info.setOnClickListener(listener);
        menu.setOnClickListener(listener);

    }

}


    //    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_info) {
//            Intent intent = new Intent(this, InfoActivity.class);
//            startActivity(intent);
//            return true;
//        } else if (id == R.id.action_attend) {
//            Intent intent = new Intent(this, AttendActivity.class);
//            startActivity(intent);
//            return true;
//        } else if (id == R.id.action_score) {
//            Intent intent = new Intent(this, ScoreActivity.class);
//            startActivity(intent);
//            return true;
//        } else if (id == R.id.action_teacher_info) {
//            Intent intent = new Intent(this, TeacherInfoActivity.class);
//            startActivity(intent);
//            return true;
//        }  else if (id == R.id.action_teacher_info) {
//            Intent intent = new Intent(this, TeacherInfoActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

