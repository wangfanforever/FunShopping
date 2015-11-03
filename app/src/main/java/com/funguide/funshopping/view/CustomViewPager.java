package com.funguide.funshopping.view;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class CustomViewPager extends ViewPager{
	
	private int viewPagerIndex = 0;
	private boolean viewPagerTaskIsRunning = false;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case -1:
				CustomViewPager.this.setCurrentItem((Integer) msg.obj);
				break;

			default:
				break;
			}
		}
	};

    public CustomViewPager(Context context) {
        super(context);
    }
    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public void setOnPageChangeListener(final OnPageChangeListener listener) {
    	
    	super.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				viewPagerIndex = arg0;
				listener.onPageSelected(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				listener.onPageScrolled(arg0, arg1, arg2);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				if (arg0 == 0 && !viewPagerTaskIsRunning) {
					runViewpagerTask();
				}else if (arg0 == 1 && viewPagerTaskIsRunning) {
					viewPagerTaskIsRunning = false;
					timer.cancel();
				}
				listener.onPageScrollStateChanged(arg0);
			}
		});
    }
    
    private Timer timer = null;
	/**
	 * 执行viewpager定时任务
	 */
	private void runViewpagerTask() {
		viewPagerTaskIsRunning = true;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				viewPagerIndex++;
				Message msg = new Message();
				msg.what = -1;
				if (viewPagerIndex >= getAdapter().getCount()){
					viewPagerIndex = 0;
				}
				msg.obj = viewPagerIndex;
				handler.sendMessage(msg);
			}
		};
		timer.schedule(task, 6000, 6000);
	}
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

       /* int height = 0;
        for(int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if(h > height) height = h;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);*/

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
