package me.shaohui.scrollablelayoutexample;

import com.squareup.picasso.Picasso;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import me.shaohui.scrollablelayout.ScrollableHelper;
import me.shaohui.scrollablelayout.ScrollableLayout;

public class MainActivity extends AppCompatActivity {

    private ScrollableLayout mScrollableLayout;

    private ImageView mHeaderView;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mHeaderView = (ImageView) findViewById(R.id.header);
        mScrollableLayout = (ScrollableLayout) findViewById(R.id.scrollable_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mFragments = new ArrayList<>();
        mFragments.add(new ScrollableFragment());
        mFragments.add(new ScrollableFragment());

        mScrollableLayout.getHelper().setScrollableContainer(
                (ScrollableHelper.ScrollableContainer) mFragments.get(0));

        Picasso.with(this)
                .load("http://img.hb.aicdn.com/c5a6d885f4372ec1192cde2877e3a74f35455ccd45096-YCbtu2_fw658")
                .into(mHeaderView);

        mViewPager.setAdapter(new ScrollablePagerAdapter(getSupportFragmentManager(), mFragments));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mScrollableLayout.getHelper().setScrollableContainer(
                        (ScrollableHelper.ScrollableContainer) mFragments.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private static class ScrollablePagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public ScrollablePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "消息";
            } else {
                return "照片";
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}
