package com.funguide.funshopping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.funguide.funshopping.module.home.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2015-11-04.
 */
public class CategoryPageAdapter extends FragmentPagerAdapter {

    private final List<String> catalogs = new ArrayList<String>();

    public CategoryPageAdapter(FragmentManager fm) {
        super(fm);
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");
        catalogs.add("化妆品");

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return catalogs.get(position);
    }

    @Override
    public int getCount() {
        return catalogs.size();
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(position);
    }

}
