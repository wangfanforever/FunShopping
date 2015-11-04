package com.funguide.funshopping.utils;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.funguide.funshopping.R;

/**
 * Created by yangshuai in the 10:23 of 2015.11.04 .
 */
public class DraweeViewHelper {

    public static void configDraweeView(Context context, Uri uri ,DraweeView draweeView){
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(context.getResources().getDrawable(R.mipmap.ic_launcher))   // 默认图片
                .setFailureImage(context.getResources().getDrawable(R.mipmap.ic_launcher))   // 失败图片
                .setRetryImage(context.getResources().getDrawable(R.mipmap.ic_launcher))   // 重新加载
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .build();
        draweeView.setController(controller);
        draweeView.setHierarchy(hierarchy);
    }
}
