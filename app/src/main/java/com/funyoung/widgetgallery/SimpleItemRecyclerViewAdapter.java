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
    private int itemW;
    private int itemH;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
            if (mTwoPane) {
            } else {
            }
        }
    };

    SimpleItemRecyclerViewAdapter(Context context, boolean twoPane) {
        mTwoPane = twoPane;

        itemW = context.getResources().getDimensionPixelSize(R.dimen.item_view_width);
        itemH = (int) (itemW * 0.6);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        Drawable bg = ItemUtil.loadBackgroundDrawable(context);
        TextView view = ItemUtil.createCellView(context, bg);
        view.setLayoutParams(new ViewGroup.LayoutParams(itemW, itemH));
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
