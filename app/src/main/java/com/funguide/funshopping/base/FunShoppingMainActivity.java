package com.funguide.funshopping.base;

import android.os.Bundle;

import com.funguide.funshopping.R;

public class FunShoppingMainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_main);
    }

}
