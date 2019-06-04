package com.funyoung.widgetgallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.funyoung.widgetgallery.dummy.DummyContent;

import java.util.List;

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
            if (mTwoPane) {
            } else {
            }
        }
    };

    SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items,
                                  boolean twoPane) {
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        Drawable bg = ItemUtil.loadBackgroundDrawable(context);
        TextView view = ItemUtil.createCellView(context, bg);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ItemUtil.bindCellView(holder.textView,
                DummyContent.ITEMS.get(position).content,
                position, mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return DummyContent.ITEMS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView view) {
            super(view);
            textView = view;
        }
    }
}
