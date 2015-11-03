package com.funguide.funshopping.base;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.funguide.funshopping.R;

public class FunShoppingMainActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener{

    private static final int INIT_TAB_ID = -1;
    protected int currentId = INIT_TAB_ID;

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

    @Override
    public void onClick(View v) {
        if (v.getId() == currentId)
            return;
        checkMessageNews();
        switch (v.getId()) {
            case R.id.btn_first_menu:
                setCurrentBottomView(R.id.btn_first_menu);
                break;
            case R.id.btn_second_menu:
                setCurrentBottomView(R.id.btn_second_menu);
                break;
            case R.id.btn_third_menu:
                setCurrentBottomView(R.id.btn_third_menu);
                break;
            case R.id.btn_fourth_menu:
                setCurrentBottomView(R.id.btn_fourth_menu);
                break;
            case R.id.img_pathmenu_action:  // 底部二维码扫描

                break;
        }
        super.onClick(v);
    }

    private void checkMessageNews() {

    }

    public void setCurrentBottomView(int id) {
        currentId = id;
        resetBottomMenuState();
        switch (id) {
            case R.id.btn_first_menu:
                firstBottomMenuIsClicked();
                break;
            case R.id.btn_second_menu:
                secondBottomMenuIsClicked();
                break;
            case R.id.btn_third_menu:
                thirdBottomMenuIsClicked();

                break;
            case R.id.btn_fourth_menu:
                fourthBottomMenuIsClicked();
                break;
            default:
                firstBottomMenuIsClicked();
                break;
        }
    }

    private void fourthBottomMenuIsClicked() {
        btnFourthMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_fourth_bottom_menu_en, 0, 0);
        btnFourthMenu.setTextColor(this.getResources().getColor(
                R.color.tab_selected_red));
    }

    private void thirdBottomMenuIsClicked() {
        btnThirdMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_third_bottom_menu_en, 0, 0);
        btnThirdMenu.setTextColor(this.getResources().getColor(
                R.color.tab_selected_red));
    }

    private void secondBottomMenuIsClicked() {
        btnSecondMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_second_bottom_menu_en, 0, 0);
        btnSecondMenu.setTextColor(this.getResources().getColor(
                R.color.tab_selected_red));
    }

    private void firstBottomMenuIsClicked() {
        btnFirstMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_first_bottom_menu_en, 0, 0);
        btnFirstMenu.setTextColor(this.getResources().getColor(
                R.color.tab_selected_red));
    }

    private void resetBottomMenuState() {
        btnFirstMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_first_bottom_menu_un, 0, 0);
        btnSecondMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_second_bottom_menu_un, 0, 0);
        btnThirdMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_third_bottom_menu_un, 0, 0);
        btnFourthMenu.setCompoundDrawablesWithIntrinsicBounds(0,
                R.drawable.icon_fourth_bottom_menu_un, 0, 0);
        btnFirstMenu.setTextColor(getResources().getColor(
                R.color.tab_unselected_gray));
        btnSecondMenu.setTextColor(getResources().getColor(
                R.color.tab_unselected_gray));
        btnThirdMenu.setTextColor(getResources().getColor(
                R.color.tab_unselected_gray));
        btnFourthMenu.setTextColor(getResources().getColor(
                R.color.tab_unselected_gray));
    }

    //--------------与fragment 交互 start
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String message) {

    }

    @Override
    public void onFragmentChildViewOnClick(View view) {

    }
    //--------------与fragment 交互 end
}
