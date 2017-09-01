package oom.pocket.acostop.views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MAV1GA on 01/09/2017.
 */

public class Post extends LinearLayout {

    private TextView tvHeader, tvDescription;
    private ImageView image;
    private Button button;

    public Post(Context context) {
        super(context);
        final float SCALE = context.getResources().getDisplayMetrics().density;
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        initWidgets(context);
        this.setOrientation(VERTICAL);

        this.addView(tvHeader);
        this.addView(image);
        this.addView(tvDescription);
        this.addView(button);
    }

    private void initWidgets(Context context){
        tvHeader = new TextView(context);
        tvDescription = new TextView(context);
        image = new ImageView(context);
        button = new Button(context);
    }

    public void setTitle(String title){
        tvHeader.setText(title);
        tvHeader.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void setImage(Drawable drawable){
        image.setImageDrawable(drawable);
    }

    public void setDescription(String description){
        tvDescription.setText(description);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        button.setOnClickListener(l);
    }
}
