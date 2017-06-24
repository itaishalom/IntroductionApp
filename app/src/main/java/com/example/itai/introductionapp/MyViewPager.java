package com.example.itai.introductionapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import static com.example.itai.introductionapp.IntroductionActivity.idToImage;
public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    static class SimpleOnPageChangeListener implements OnPageChangeListener {
        private ImageView mImageOfDots;
        private Context mContext;
        private AlphaAnimation mBlinkingAnimation;

        SimpleOnPageChangeListener(Context context, ImageView imageOfDots){
            super();
            mContext = context;
            mImageOfDots = imageOfDots;
            mBlinkingAnimation = new AlphaAnimation(0.0f, 1.0f); // Change alpha from fully visible to invisible
            mBlinkingAnimation.setDuration(1000); // duration - half a second
            mBlinkingAnimation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            mBlinkingAnimation.setRepeatCount(2); // Repeat animation infinitely
            mBlinkingAnimation.setFillAfter(false);//to keep it at 0 when animation ends
            mBlinkingAnimation.setRepeatMode(Animation.REVERSE);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            int loc = position + 1;
            int imageResource = mContext.getResources().getIdentifier("@drawable/dots_" + loc, null,
                    mContext.getPackageName());
            mImageOfDots.setImageResource(imageResource);
            ImageView img = idToImage.get(loc);
            if (img != null) {
                img.startAnimation(mBlinkingAnimation);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
