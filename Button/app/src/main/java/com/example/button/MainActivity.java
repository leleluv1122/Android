package com.example.button;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = findViewById(R.id.editText);
                EditText e2 = findViewById(R.id.editText2);

                CharSequence s1 = e1.getText();
                CharSequence s2 = e2.getText();

                e1.setText(s2);
                e2.setText(s1);
            }
        };
        b.setOnClickListener(listenerObj);

    }
}
