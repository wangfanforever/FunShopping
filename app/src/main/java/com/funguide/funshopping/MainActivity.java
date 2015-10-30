package com.funguide.funshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.funguide.funshopping.bean.CommonBillsBean;
import com.funguide.funshopping.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> params = new HashMap<String, String>();
        params.put("uid", "f0022ad8621647ee941242e0a9724836");
        OkHttpClientManager.postAsyn("http://140.206.112.228:80/Merchant/life_pay/commonBills.json?", params, new OkHttpClientManager.ResultCallback<CommonBillsBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(CommonBillsBean response) {

                Log.i("--2323----", response.toString());
                Log.i("--2323----", response.toString());
                Log.i("--2323----", response.toString());
                Log.i("--2323----", response.toString());
                Log.i("--2323----", response.toString());

            }
        });
    }
}
