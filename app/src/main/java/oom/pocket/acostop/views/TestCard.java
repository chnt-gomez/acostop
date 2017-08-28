package oom.pocket.acostop.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import oom.pocket.acostop.R;

/**
 * Created by MAV1GA on 28/08/2017.
 */



public class TestCard extends LinearLayout {


    private static float SCALE;

    private TextView label, display;
    private Button button;

    public TestCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        SCALE = context.getResources().getDisplayMetrics().density;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Label,
                0,0
        );
        try{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            this.setPadding(toDp(4),toDp(4),toDp(4), toDp(4));
            this.setLayoutParams(params);
            label = new TextView(context);
            display = new TextView(context);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            button = new Button(context, null, R.style.simpleButton);
            buttonParams.setMargins(0,0,0, toDp(8));
            buttonParams.gravity = Gravity.CENTER_HORIZONTAL;

            button.setLayoutParams(buttonParams);
            this.setOrientation(VERTICAL);
            label.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            label.setTypeface(Typeface.DEFAULT_BOLD);
            display.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            button.setTypeface(Typeface.DEFAULT_BOLD);
            button.setText(a.getString(R.styleable.Label_label_text).toUpperCase());
            label.setText(a.getString(R.styleable.Label_label_text));
            display.setText(a.getString(R.styleable.Label_display_text));
            button.setGravity(Gravity.CENTER_HORIZONTAL);
            button.setId(a.getResourceId(R.styleable.Label_button_id, 0));
            button.setBackgroundResource(R.drawable.selector_button);
            button.setPadding(toDp(12), toDp(12), toDp(12), toDp(12));
            this.addView(button);
            this.addView(display);
        }finally{
            a.recycle();
        }



    }

    public void setDisplay(String displayText){
        display.setText(displayText);
        invalidate();
        requestLayout();
    }

    public void setLabel(String labelText){
        label.setText(labelText);
        invalidate();
        requestLayout();
    }

    public void setOnButtonClickListener(OnClickListener listener){
        button.setOnClickListener(listener);
    }

    private int toDp(float pixels){
        return (int)(pixels * SCALE + 0.5F);
    }

}
