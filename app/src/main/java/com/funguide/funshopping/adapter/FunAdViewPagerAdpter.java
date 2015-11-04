package com.funguide.funshopping.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by yangshuai in the 14:53 of 2015.11.03 .
 */
public class FunAdViewPagerAdpter extends PagerAdapter {

    private Context context;
    private ArrayList<SimpleDraweeView> picViews;
    private int mChildeCount = 0;

    public FunAdViewPagerAdpter( Context context, ArrayList<SimpleDraweeView> picViews) {
        this.picViews = picViews;
        this.context = context;
        mChildeCount = picViews.size();
    }

    @Override
    public void notifyDataSetChanged() {
        mChildeCount = getCount();
        super.notifyDataSetChanged();

    }

    @Override
    public int getItemPosition(Object object) {

        if (mChildeCount > 0) {
            mChildeCount --;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return picViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        ViewPager mViewPager = (ViewPager) view;
        mViewPager.addView(picViews.get(position));
        return picViews.get(position);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        viewPager.removeView((View)object);
    }
}
