package com.funyoung.widgetgallery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class ItemUtil {
    private final static int textColor = Color.BLUE;

    public static TextView createCellView(Context context, Drawable bg) {
        TextView textView = new TextView(context);
        textView.setBackground(bg);
        textView.setTextColor(textColor);
        textView.setMaxLines(1);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(2, 10, 2, 10);

        return textView;
    }

    public static Drawable loadBackgroundDrawable(Context context) {
        return context.getResources().getDrawable(R.drawable.background);
    }

    public static void bindCellView(TextView textView, String content, int index,
                                    View.OnClickListener clickListener) {
        textView.setTag(index);
        textView.setText(content);
        textView.setOnClickListener(clickListener);
    }
}
