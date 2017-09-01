package oom.pocket.acostop.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import oom.pocket.acostop.R;

/**
 * Created by MAV1GA on 28/08/2017.
 */



public class TestCard extends LinearLayout {


    private static float SCALE;

    private TextView label;
    private ImageButton button;

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
            this.setLayoutParams(params);
            label = new TextView(context);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            this.setBackgroundResource(R.drawable.border_simple);
            textParams.gravity = Gravity.CENTER_VERTICAL;
            this.setOrientation(HORIZONTAL);
            button = new ImageButton(context, null);
            button.setImageResource(a.getResourceId(R.styleable.Label_button_src, R.drawable.ic_pencil));
            button.setBackgroundResource(a.getResourceId(R.styleable.Label_button_background, R.drawable.selector_button_info));
            buttonParams.setMargins(0,0,toDp(6), 0);
            button.setLayoutParams(buttonParams);
            label.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            label.setText(a.getString(R.styleable.Label_label_text));
            label.setLayoutParams(textParams);
            button.setId(a.getResourceId(R.styleable.Label_button_id, 0));
            button.setPadding(toDp(12), toDp(12), toDp(12), toDp(12));
            this.addView(button);
            this.addView(label);
        }finally{
            a.recycle();
        }



    }

    public void setOnButtonClickListener(OnClickListener listener){
        button.setOnClickListener(listener);
    }

    private int toDp(float pixels){
        return (int)(pixels * SCALE + 0.5F);
    }

}
