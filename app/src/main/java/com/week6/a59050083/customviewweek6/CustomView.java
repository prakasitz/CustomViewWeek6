package com.week6.a59050083.customviewweek6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CustomView extends AppCompatActivity {

    private  CustomCircleButton btCustomCircle;
    private  CustomOnOffButton btOnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        btCustomCircle = findViewById(R.id.btCustomCircle);
        btCustomCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomView.this,
                        "OPEN:"+btCustomCircle.isOn(),Toast.LENGTH_LONG).show();
            }
        });

        btOnOff = findViewById(R.id.btCustomOnOff);
        btOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomView.this,
                        "OPEN:"+btOnOff.isOn(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
