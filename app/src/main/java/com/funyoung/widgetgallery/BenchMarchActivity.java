package com.funyoung.widgetgallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.funyoung.widgetgallery.dummy.DummyContent;

public class BenchMarchActivity extends AppCompatActivity {
    private static final String USING_FLAG = "USING_FLAG";

    private int itemW;
    private int itemH;
    private final int textColor = Color.BLUE;

    public static void start(Activity activity, boolean useScrollView) {
        Intent intent = new Intent(activity, BenchMarchActivity.class);
        intent.putExtra(USING_FLAG, useScrollView);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemW = getResources().getDimensionPixelSize(R.dimen.item_view_width);
        itemH = (int) (itemW * 0.6);

        boolean usingScrollView = getIntent().getBooleanExtra(USING_FLAG, false);
        if (usingScrollView) {
            setContentView(R.layout.activity_benchmarch_scrollview);
            setUpScrollView();
        } else {
            setContentView(R.layout.activity_benchmarch_recyclerview);
            setUpRecyclerView();
        }
    }

    private LinearLayout mLayout;
    private void setUpScrollView() {
        ViewGroup parent = findViewById(R.id.scrollView);
        setBackground(parent);

        if (mLayout == null) {
            mLayout = new LinearLayout(getApplicationContext());
            mLayout.setOrientation(LinearLayout.VERTICAL);
            mLayout.setGravity(Gravity.CENTER);
        } else {
            int count = mLayout.getChildCount();
            for (int i = 0; i < count; i++) {
                View view = mLayout.getChildAt(i);
                recycleView(view);
            }
            mLayout.removeAllViews();
        }

        int layoutW = itemW;
        int layoutH = 0;

        Context context = getApplicationContext();
        for (int i = 0; i < DummyContent.ITEMS.size(); i++) {
            DummyContent.DummyItem item = DummyContent.ITEMS.get(i);
            if (item == null) {
                continue;
            }
            TextView textView = new TextView(context);
            textView.setBackground(loadBackgroundDrawable());
            textView.setText(item.content);
            textView.setTextColor(textColor);
            textView.setMaxLines(1);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(2, 10, 2, 10);
            final int index = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleItemClick(index);
                }
            });

            LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(itemW, itemH);
            mLayout.addView(textView, params);
            layoutH += itemH;
        }
        ViewGroup.LayoutParams params = mLayout.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(layoutW, layoutH);
            parent.addView(mLayout, params);
        } else {
            params.width = layoutW;
            params.height = layoutH;
            parent.invalidate();
        }
    }

    private void recycleView(View view) {
    }

    private void setUpRecyclerView() {
        ViewGroup parent = findViewById(R.id.recyclerView);
        setBackground(parent);
    }

    private void setBackground(ViewGroup parent) {
        parent.setBackgroundResource(R.drawable.background);
    }
    private Drawable loadBackgroundDrawable() {
        return getResources().getDrawable(R.drawable.background);
    }

    // todo: while code is click
    private void handleItemClick(int index) {
    }
}