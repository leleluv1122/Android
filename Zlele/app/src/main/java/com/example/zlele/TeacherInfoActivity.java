package com.example.zlele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TeacherInfoActivity extends AppCompatActivity {

    TextView nameview;
    TextView majorview;
    TextView officeview;
    TextView emailview;

    ImageButton beforebtn;
    ImageButton nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherinfo);

        nameview = (TextView) findViewById((R.id.pro_name));
        majorview = (TextView) findViewById((R.id.pro_major));
        officeview = (TextView) findViewById((R.id.pro_office));
        emailview = (TextView) findViewById((R.id.pro_email));

        beforebtn = (ImageButton) findViewById(R.id.btn_before);
        nextbtn = (ImageButton) findViewById(R.id.btn_next);

        beforebtn.setOnClickListener((View.OnClickListener) this);
        nextbtn.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v){
        if(v==beforebtn){
            beforeFunc();
        }
        else if(v==nextbtn){
            nextFunc();
        }
    }

    private void beforeFunc(){

    }
    private void nextFunc(){

    }
}
