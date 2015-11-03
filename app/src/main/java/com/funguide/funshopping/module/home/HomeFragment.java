package com.funguide.funshopping.module.home;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.funguide.funshopping.R;
import com.funguide.funshopping.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private LinearLayout homeLayoutContainer;


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
        for (int i = 0 ; i < 5; i++){
            SimpleDraweeView draweeView = new SimpleDraweeView(getActivity());
            draweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
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
