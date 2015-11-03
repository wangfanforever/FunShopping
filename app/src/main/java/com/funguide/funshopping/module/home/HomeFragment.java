package com.funguide.funshopping.module.home;


import android.app.Fragment;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.funguide.funshopping.R;
import com.funguide.funshopping.adapter.FunAdViewPagerAdpter;
import com.funguide.funshopping.base.BaseFragment;
import com.funguide.funshopping.utils.Log;
import com.funguide.funshopping.view.autoscrollviewpager.AutoScrollViewPager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private LinearLayout homeLayoutContainer;
    private AutoScrollViewPager adViewPager;

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
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBinner();
    }

    /* 初始化广告 */
    private void initBinner(){
        String img_path = "https://s-media-cache-ak0.pinimg.com/736x/b3/46/a8/b346a8f5ea9a2ed94ffd20dfaf607aa5.jpg";
        Uri uri = Uri.parse(img_path);
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setPlaceholderImage(getResources().getDrawable(R.mipmap.ic_launcher))
                .setFailureImage(getResources().getDrawable(R.mipmap.ic_launcher))
                .setRetryImage(getResources().getDrawable(R.mipmap.ic_launcher))
                .build();
        for (int i = 0 ; i < 5; i++){
            SimpleDraweeView draweeView = new SimpleDraweeView(getActivity(), hierarchy);
            draweeView.setId(i);
            draweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            draweeView.setImageURI(uri);
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
