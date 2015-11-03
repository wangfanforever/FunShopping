package com.funguide.funshopping.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.funguide.funshopping.R;

public class FunShoppingMainActivity extends BaseActivity {

    public Button btnFirstMenu;
    public Button btnSecondMenu;
    public Button btnThirdMenu;
    public Button btnFourthMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_main);

        initBottomMenuView();
        addBottomPathMenu(getBaseLayout());
    }

    private void initBottomMenuView() {
        setBottomLayoutVisible();
        addBottomView(R.layout.base_bottom_bar);
        btnFirstMenu = (Button) findViewById(R.id.btn_first_menu);
        btnFirstMenu.setOnClickListener(this);
        btnSecondMenu = (Button) findViewById(R.id.btn_second_menu);
        btnSecondMenu.setOnClickListener(this);
        btnThirdMenu = (Button) findViewById(R.id.btn_third_menu);
        btnThirdMenu.setOnClickListener(this);
        btnFourthMenu = (Button) findViewById(R.id.btn_fourth_menu);
        btnFourthMenu.setOnClickListener(this);
    }

    private void addBottomPathMenu(RelativeLayout container) {
        final View view = LayoutInflater.from(this).inflate(
                R.layout.bottom_path_menu, null);
        final View actionview = view.findViewById(R.id.img_pathmenu_action);
        actionview.setOnClickListener(this);
        RelativeLayout.LayoutParams rlps = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        rlps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        rlps.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        container.addView(view, rlps);
    }

}
