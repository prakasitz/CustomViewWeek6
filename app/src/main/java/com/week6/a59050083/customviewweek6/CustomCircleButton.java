package com.week6.a59050083.customviewweek6;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
public class CustomCircleButton extends View{
    private boolean isOn = false;
    private Paint paint;
    private float textSizeSP;
    private float textSizePX;
    private String onText;
    private String offText;
    private int onTextColor;
    private int offTextColor;
    private int onBgColor;
    private int offBgColor;
    private static final float DEFAULT_TEXT_SIZE_SP = 20;
    private static final String DEFAULT_ON_TEXT = "ON";
    private static final String DEFAULT_OFF_TEXT = "OFF";
    private static final String DEFAULT_ON_TEXT_COLOR = "#ffffff";
    private static final String DEFAULT_OFF_TEXT_COLOR = "#ffffff";
    private static final String DEFAULT_ON_TEXT_BG_COLOR = "#00ff00";
    private static final String DEFAULT_OFF_TEXT_BG_COLOR = "#000000";
    public CustomCircleButton(Context context){
        super(context);
    }
    public CustomCircleButton(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context, attrs, 0, 0);
    }
    public CustomCircleButton(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomCircleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }
    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        paint = new Paint();
        TypedArray attributeValuesArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomCircleButton,
                defStyleAttr, defStyleRes);
        try{
            textSizeSP = attributeValuesArray.
                    getFloat(R.styleable.CustomCircleButton_textSize1, DEFAULT_TEXT_SIZE_SP);
            textSizePX = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSizeSP,
                    getResources().getDisplayMetrics());
            onText = attributeValuesArray.
                    getString(R.styleable.CustomCircleButton_onText);
            offText = attributeValuesArray.
                    getString(R.styleable.CustomCircleButton_offText);
            if(onText == null){
                onText = DEFAULT_ON_TEXT;
            }
            if(offText == null){
                offText = DEFAULT_OFF_TEXT;
            }
            onTextColor = attributeValuesArray.
                    getInteger(R.styleable.CustomCircleButton_onTextColor, Color.parseColor(DEFAULT_ON_TEXT_COLOR));
            offTextColor = attributeValuesArray.
                    getInteger(R.styleable.CustomCircleButton_offTextColor, Color.parseColor(DEFAULT_OFF_TEXT_COLOR));
            onBgColor = attributeValuesArray.
                    getInteger(R.styleable.CustomCircleButton_onBgColor, Color.parseColor(DEFAULT_ON_TEXT_BG_COLOR));
            offBgColor = attributeValuesArray.
                    getInteger(R.styleable.CustomCircleButton_offBgColor, Color.parseColor(DEFAULT_OFF_TEXT_BG_COLOR));
        }finally{
            attributeValuesArray.recycle();
        }
    }
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        if(isOn){
            paint.setColor(onBgColor);
        }else{
            paint.setColor(offBgColor);
        }
        int centerX = this.getMeasuredWidth() / 2;
        int centerY = this.getMeasuredHeight() / 2;
        int radius = centerX > centerY ? centerY : centerX;
        canvas.drawCircle(centerX, centerY, radius, paint);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(textSizePX);
        if(isOn){
            paint.setColor(onTextColor);
            canvas.drawText(onText, centerX, centerY + (int) (textSizePX / 2), paint);
        }else{
            paint.setColor(offTextColor);
            canvas.drawText(offText, centerX, centerY + (int) (textSizePX / 2), paint);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isOn = !isOn;
                invalidate();
                return performClick();
            default:
                return false;
        }
    }
    public boolean isOn(){
        return isOn;
    }
}
