package me.shaohui.scrollablelayoutexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.shaohui.scrollablelayout.ScrollableHelper;

/**
 * Created by shaohui on 2017/2/9.
 */

public class ScrollableFragment extends Fragment implements ScrollableHelper.ScrollableContainer {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getContext());
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ScrollableAdapter());
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        return mRecyclerView;
    }

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }
}
