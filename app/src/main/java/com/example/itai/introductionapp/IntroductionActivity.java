package com.example.itai.introductionapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.widget.ImageView;

public class IntroductionActivity extends FragmentActivity {

    public static SparseArray<ImageView> idToImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        MyViewPager mViewPager = (MyViewPager) findViewById(R.id.view_pager);
        SwipingAdapter swipingAdapter = new SwipingAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(swipingAdapter);

        ImageView imageDots = (ImageView) findViewById(R.id.dots);
        int imageResource = getResources().getIdentifier("@drawable/dots_1", null,
                this.getPackageName());
        imageDots.setImageResource(imageResource);

        idToImage = new SparseArray<>();

        MyViewPager.SimpleOnPageChangeListener lis = new MyViewPager.SimpleOnPageChangeListener(this,
                imageDots);
        mViewPager.addOnPageChangeListener(lis);
    }
}
