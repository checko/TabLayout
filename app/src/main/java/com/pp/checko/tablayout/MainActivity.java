package com.pp.checko.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "TABLAYOUT";

    private android.support.design.widget.TabLayout mTabs;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabs = (android.support.design.widget.TabLayout) findViewById(R.id.tabs);
        mTabs.addTab(mTabs.newTab().setText("Tab 1"));
        mTabs.addTab(mTabs.newTab().setText("Tab 2"));
        mTabs.addTab(mTabs.newTab().setText("Tab 3"));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));

        mTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void OnButtonClicked(View v) {
        switch(v.getId()){
            case R.id.btn1:
                Log.i(TAG,"1");
                break;
            case R.id.btn2:
                Log.i(TAG,"2");
                break;
            case R.id.btn3:
                Log.i(TAG,"3");
                break;
            default:
                Log.i(TAG,"something..");
        }
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int  getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item" + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.i(TAG,"instantiateItem" + position );
            View view;
            switch(position) {
                case 0:
                    view = getLayoutInflater().inflate(R.layout.page_1,container,false);
                    break;
                case 1:
                    view = getLayoutInflater().inflate(R.layout.page_2,container,false);
                    break;
                case 2:
                default:
                    view = getLayoutInflater().inflate(R.layout.page_3,container,false);
                    break;
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
