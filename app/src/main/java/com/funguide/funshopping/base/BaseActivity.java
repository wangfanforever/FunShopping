package com.funguide.funshopping.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.funguide.funshopping.R;
import com.funguide.funshopping.utils.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangshuai on 2015/9/25 0025.
 */
public class BaseActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout baseLayout;
    private RelativeLayout actionBarRlt;
    private Button actionBarLeftBtn;
    private Button actionBarRightBtn;
    private TextView actionBarTitle;
    private LinearLayout contentFatherLly;
    private LinearLayout bottomMenuLly;


    @Override
    public void onCreate(Bundle savedInstanceState) {
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        Set<RequestListener> listeners = new HashSet<>();
        listeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setRequestListeners(listeners)
                .build();
        Fresco.initialize(this, config);

        setContentView(R.layout.activity_base);

        SharedPreferenceUtil.init(this);

        baseLayout = (RelativeLayout) findViewById(R.id.base_layout);

        actionBarLeftBtn = (Button) findViewById(R.id.actionBar_left_btn);
        actionBarRightBtn = (Button) findViewById(R.id.actionBar_right_btn);
        actionBarTitle = (TextView) findViewById(R.id.actionBar_title_tv);
        actionBarRlt = (RelativeLayout) findViewById(R.id.action_bar_rlt);

        contentFatherLly = (LinearLayout) findViewById(R.id.base_content_father_lly);
        bottomMenuLly = (LinearLayout) findViewById(R.id.bottom_menu_lly);
//        fillLayoutView();   不推荐自动添加布局
    }

    private void fillLayoutView() {
        String layoutName = getLayoutName();
        int layoutId = getFieldValue("layout", layoutName, this);
        if (layoutId != -1) {
            setContentLayout(layoutId);
        }

    }

    private String getLayoutName() {
        String className = this.getClass().getSimpleName();
        className = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
        Pattern p = Pattern.compile("\\p{Upper}");
        Matcher m = p.matcher(className);

        ArrayList<String> names = new ArrayList<String>();

        int index = 0;
        int lastIndex = index;
        while (m.find()) {
            index = className.indexOf(m.group());
            names.add(className.substring(lastIndex, index));
            lastIndex = index;
        }
        names.add(className.substring(lastIndex, className.length()));

//        Collections.reverse(names);
        className = names.get(names.size() - 1);
        for (int i = 0; i < names.size() - 1; i++) {
            className += "_" + names.get(i);
        }
        return className.toLowerCase();
    }

    /**
     * 根据给定的类型名和字段名，返回R文件中的字段的值
     *
     * @param typeName  属于哪个类别的属性 （id,layout,drawable,string,color,attr......）
     * @param fieldName 字段名
     * @return 字段的值
     * @throws Exception
     */
    public static int getFieldValue(String typeName, String fieldName, Context context) {
        int i = -1;
        try {
            Class<?> clazz = Class.forName(context.getPackageName() + ".R$" + typeName);
            i = clazz.getField(fieldName).getInt(null);
        } catch (Exception e) {
            Log.d("" + context.getClass(), "没有找到" + context.getPackageName() + ".R$" + typeName + "类型资源 " + fieldName + "请copy相应文件到对应的目录.");
            return -1;
        }
        return i;
    }

    protected void setContentLayout(int layoutId) {
        View sonView = LayoutInflater.from(this).inflate(layoutId, null);
        contentFatherLly.addView(sonView);
        getChildViewForm(getWindow().getDecorView());
    }

    protected void setContentLayout(View view) {
        contentFatherLly.addView(view);
        getChildViewForm(getWindow().getDecorView());
    }

    private void getChildViewForm(View view) {
        try {
            if (view instanceof ViewGroup) {
                ViewGroup g = (ViewGroup) view;
                for (int i = 0; i < g.getChildCount(); i++) {
                    getChildViewForm(g.getChildAt(i));
                }
            } else if (view instanceof Button) {
                view.setOnClickListener(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected RelativeLayout getBaseLayout(){
        return baseLayout;
    }

    protected void showActionBar() {
        actionBarRlt.setVisibility(View.VISIBLE);
    }

    protected void hideActionBar() {
        actionBarRlt.setVisibility(View.GONE);
    }

    protected void showActionBarLeftBtn() {
        actionBarLeftBtn.setVisibility(View.VISIBLE);
    }

    protected void hideActionBarLeftBtn() {
        actionBarLeftBtn.setVisibility(View.GONE);
    }

    protected void showActionBarRightBtn() {
        actionBarRightBtn.setVisibility(View.VISIBLE);
    }

    protected void hideActionBarRightBtn() {
        actionBarRightBtn.setVisibility(View.GONE);
    }

    protected void showActionBarTitle() {
        actionBarTitle.setVisibility(View.VISIBLE);
    }

    protected void hideActionBarTitle() {
        actionBarTitle.setVisibility(View.GONE);
    }

    //设置中间标题的文本
    protected void setActionBarTitle(String title) {
        actionBarTitle.setText(title);
    }

    //设置toast文本
    protected void changeToastState(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    //设置左侧按钮的文本
    protected void setActionBarLeftBtnText(String text) {
        actionBarLeftBtn.setText(text);
    }

    //设置左侧按钮的文本
    protected void setActionBarRightBtnText(String text) {
        actionBarRightBtn.setText(text);
    }

    public void setBottomLayoutVisible() {
        bottomMenuLly.setVisibility(View.VISIBLE);
    }

    public void addBottomView(int resId) {
        View bottomView = LayoutInflater.from(this).inflate(resId, null);
        bottomMenuLly.removeAllViews();
        bottomMenuLly.addView(bottomView, new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void addBottomView(View view) {
        View bottomView = view;
        bottomMenuLly.removeAllViews();
        bottomMenuLly.addView(bottomView, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    //双击退出
    private long exitTime = -1;

    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            changeToastState("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

    //双击返回键退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((this instanceof FunShoppingMainActivity) && event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    //Toast公共方法
    private Toast toast = null;

    protected void showToast(String message) {
        if (toast == null) {
            toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    @Override
    public void onClick(View v) {

    }
}
