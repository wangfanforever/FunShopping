package com.funguide.funshopping.module.home;


import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.funguide.funshopping.R;
import com.funguide.funshopping.adapter.CategoryPageAdapter;
import com.funguide.funshopping.adapter.FunAdViewPagerAdpter;
import com.funguide.funshopping.base.BaseFragment;
import com.funguide.funshopping.utils.DraweeViewHelper;
import com.funguide.funshopping.view.CategoryTabStrip;
import com.funguide.funshopping.view.autoscrollviewpager.AutoScrollViewPager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private LinearLayout homeLayoutContainer;
    private AutoScrollViewPager adViewPager;
    private CategoryTabStrip tabs;
    private ViewPager pager;
    private CategoryPageAdapter cAdapter;
    /* 存储广告图像 */
    private ArrayList<SimpleDraweeView> adPicViews = new ArrayList<SimpleDraweeView>();


    public static HomeFragment newInstance(String param1, String param2) {
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeLayoutContainer = (LinearLayout) view.findViewById(R.id.home_container_lly);
        adViewPager = (AutoScrollViewPager) view.findViewById(R.id.home_ad_viewpager);
        tabs = (CategoryTabStrip) view.findViewById(R.id.category_strip);
        pager = (ViewPager) view.findViewById(R.id.view_pager);
        cAdapter = new CategoryPageAdapter(getFragmentManager());

        pager.setAdapter(cAdapter);

        tabs.setViewPager(pager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBinner();
        initToolsLayout();
    }


    /* 初始化广告 */
    private void initBinner(){
        String img_path1 = "http://ad.funguide.com.cn/image/1410247238260.jpg";
        String img_path2 = "http://ad.funguide.com.cn/image/1410936959581.jpg";
        String img_path3 = "http://ad.funguide.com.cn/image/1410246670847.jpg";
        String img_path[]={img_path1,img_path2,img_path3};
        for (int i = 0 ; i < img_path.length; i++){
            Uri uri = Uri.parse(img_path[i]);
            SimpleDraweeView draweeView = new SimpleDraweeView(getActivity());
            DraweeViewHelper.configDraweeView(getActivity(), uri, draweeView);
            draweeView.setId(i);
            adPicViews.add(draweeView);
        }
        FunAdViewPagerAdpter funAdViewPagerAdpter = new FunAdViewPagerAdpter(getActivity(), adPicViews);
        adViewPager.setOffscreenPageLimit(adPicViews.size());
        adViewPager.startAutoScroll();
        adViewPager.setInterval(3000);
        adViewPager.setCycle(true);
        adViewPager.setSlideBorderMode(AutoScrollViewPager.SLIDE_BORDER_MODE_CYCLE);
        adViewPager.setAdapter(funAdViewPagerAdpter);
    }

    private void initToolsLayout() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_tools_view, null);
        homeLayoutContainer.addView(view);
    }

    @Override
    protected void onFragmentSeleted(boolean isFirst) {

    }

    @Override
    protected void onFragmentUnSeleted() {

    }


    @Override
    public void onClick(View v) {

    }
}
