package com.funguide.funshopping.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import com.funguide.funshopping.utils.Log;

/** 
 * @author yangshuai
 * @version 创建时间：2015-8-20 上午11:10:28 
 * 类说明 :
 */
public class FunScrollView extends ScrollView{

	public FunScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public FunScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FunScrollView(Context context) {
		super(context);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		getChildAt(0).dispatchTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
		
	}
}
