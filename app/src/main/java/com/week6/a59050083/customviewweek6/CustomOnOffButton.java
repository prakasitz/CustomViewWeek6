package com.week6.a59050083.customviewweek6;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class CustomOnOffButton extends FrameLayout{
    private Button btnOn, btnOff;
    private boolean isOn = false;
    private String onText;
    private String offText;
    private int onTextColor;
    private int offTextColor;
    private int onBgColor;
    private int offBgColor;
    private final String COLOR_DISABLE_BUTTON_BACKGROUND = "#fffff9";
    private final String COLOR_DISABLE_BUTTON_TEXT = "#918c8c";
    private final String COLOR_ON_BUTTON_BACKGROUND = "#00ff00";
    private final String COLOR_ON_BUTTON_TEXT = "#000000";
    private final String COLOR_OFF_BUTTON_BACKGROUND = "#8c8787";
    private final String COLOR_OFF_BUTTON_TEXT = "#000000";

    public CustomOnOffButton(Context context){
        super(context);
        inflate();
    }

    public CustomOnOffButton(Context context, AttributeSet attrs){
        super(context, attrs);
        inflate();
        init(context, attrs, 0, 0);
    }

    public CustomOnOffButton(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
        inflate();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomOnOffButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate();
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        TypedArray attributeValuesArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomOnOffButton,
                defStyleAttr, defStyleRes);
        try{

            onTextColor = attributeValuesArray.
                    getInteger(R.styleable.CustomOnOffButton_onTextColor, Color.parseColor(COLOR_ON_BUTTON_TEXT));
            offTextColor = attributeValuesArray.
                    getInteger(R.styleable.CustomOnOffButton_offTextColor, Color.parseColor(COLOR_OFF_BUTTON_TEXT));
            onBgColor = attributeValuesArray.
                    getInteger(R.styleable.CustomOnOffButton_onBgColor, Color.parseColor(COLOR_ON_BUTTON_BACKGROUND));
            offBgColor = attributeValuesArray.
                    getInteger(R.styleable.CustomOnOffButton_offBgColor, Color.parseColor(COLOR_OFF_BUTTON_BACKGROUND));
        }finally{
            attributeValuesArray.recycle();
        }
        btnOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);
        setButtonStyle();
        btnOn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(!isOn){
                    isOn = !isOn;
                    setButtonStyle();
                }
                CustomOnOffButton.this.performClick();
            }
        });
        btnOff.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(isOn){
                    isOn = !isOn;
                    setButtonStyle();
                }
                CustomOnOffButton.this.performClick();
            }
        });

    }

    public boolean isOn(){
        return isOn;
    }

    private void inflate(){
        inflate(getContext(), R.layout.custom_onoff_button_layout, this);
    }



    private void setButtonStyle(){
        if(isOn){
            btnOn.setTextColor(onTextColor);
            btnOn.setBackgroundColor(onBgColor);
            btnOff.setTextColor(offTextColor);
            btnOff.setBackgroundColor(offBgColor);
        }else{
            btnOn.setTextColor(Color.parseColor(COLOR_DISABLE_BUTTON_TEXT));
            btnOn.setBackgroundColor(Color.parseColor(COLOR_DISABLE_BUTTON_BACKGROUND));
            btnOff.setTextColor(Color.parseColor(COLOR_OFF_BUTTON_TEXT));
            btnOff.setBackgroundColor(Color.parseColor(COLOR_OFF_BUTTON_BACKGROUND));
        }
    }

}

