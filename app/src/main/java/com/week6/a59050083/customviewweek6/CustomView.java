package com.week6.a59050083.customviewweek6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CustomView extends AppCompatActivity {

    private  CustomCircleButton btCustomCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        btCustomCircle = findViewById(R.id.sasdsa);
        btCustomCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomView.this,
                        "OPEN:"+btCustomCircle.isOn(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
