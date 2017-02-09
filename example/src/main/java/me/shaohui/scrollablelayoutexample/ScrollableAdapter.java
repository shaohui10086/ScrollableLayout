package me.shaohui.scrollablelayoutexample;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shaohui on 2017/2/9.
 */

public class ScrollableAdapter extends RecyclerView.Adapter<ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScrollableVh(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_simple, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private class ScrollableVh extends RecyclerView.ViewHolder {

        public ScrollableVh(View itemView) {
            super(itemView);
        }
    }

}
