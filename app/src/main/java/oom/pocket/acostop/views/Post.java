package oom.pocket.acostop.views;

import android.content.Context;
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


    }

}
