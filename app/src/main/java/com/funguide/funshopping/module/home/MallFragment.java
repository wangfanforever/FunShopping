package com.funguide.funshopping.module.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.funguide.funshopping.R;
import com.funguide.funshopping.adapter.FunAdViewPagerAdpter;
import com.funguide.funshopping.base.BaseFragment;
import com.funguide.funshopping.utils.DraweeViewHelper;
import com.funguide.funshopping.view.autoscrollviewpager.AutoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by wang on 2015-11-04.
 */
public class MallFragment extends BaseFragment {
    private AutoScrollViewPager adViewPager;
    private TextView jingxuan, taocan;
    private View line_j, line_t;
    /* 存储广告图像 */
    private ArrayList<SimpleDraweeView> adPicViews = new ArrayList<SimpleDraweeView>();


    public static MallFragment newInstance(String param1, String param2) {
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        MallFragment fragment = new MallFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall, container, false);
        adViewPager = (AutoScrollViewPager) view.findViewById(R.id.mall_ad_viewpager);

        taocan = (TextView) view.findViewById(R.id.tv_mall_taocan);
        jingxuan = (TextView) view.findViewById(R.id.tv_mall_jingxuan);

        line_j = view.findViewById(R.id.mall_line_j);
        line_t = view.findViewById(R.id.mall_line_t);
        jingxuan.setOnClickListener(this);
        taocan.setOnClickListener(this);


        return view;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBinner();
    }

    /* 初始化广告 */
    private void initBinner() {
        String img_path1 = "http://ad.funguide.com.cn/image/1410247238260.jpg";
        String img_path2 = "http://ad.funguide.com.cn/image/1410936959581.jpg";
        String img_path3 = "http://ad.funguide.com.cn/image/1410246670847.jpg";
        String img_path[] = {img_path1, img_path2, img_path3};
        for (int i = 0; i < img_path.length; i++) {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_mall_jingxuan:
                taocan.setTextColor(getResources().getColor(R.color.mall_text));
                jingxuan.setTextColor(getResources().getColor(R.color.mall_text_t));
                line_j.setVisibility(View.VISIBLE);
                line_t.setVisibility(View.INVISIBLE);

                break;
            case R.id.tv_mall_taocan:
                taocan.setTextColor(getResources().getColor(R.color.mall_text_t));
                jingxuan.setTextColor(getResources().getColor(R.color.mall_text));
                line_j.setVisibility(View.INVISIBLE);
                line_t.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onFragmentSeleted(boolean isFirst) {

    }

    @Override
    protected void onFragmentUnSeleted() {

    }

}
