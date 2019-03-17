package com.example.srk.noice;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnScreen extends AppCompatActivity {

    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;

    private TextView mDots[]; // for dots

    private SliderAdapter sliderAdapter;

    private Button mPrev, mSkip;

    private int mCurrentPage;

    //Indicates the dot change in color according to the pages
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            mCurrentPage = position;

            //logic inside the next and prev buttons
            if (position == 0) {
//                mSkip.setEnabled(true);
                mPrev.setEnabled(false);
//                mPrev.setVisibility(View.INVISIBLE);
                mSkip.setText("Skip");
                mPrev.setText("");
            } else if (position == mDots.length - 1) { /** logic inside finish button this is an important part*/
//                mt.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);
                mSkip.setText("Finish");
                mPrev.setText("Back");
            } else {
//                mSkip.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);
                mSkip.setText("Skip");
                mPrev.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    // Adding dots
    public void addDotIndicator(int position) {
        mDots = new TextView[3];

        mDotLayout.removeAllViews(); // fixes dots on all page

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_screen);

        mSlideViewpager = findViewById(R.id.mainVP);
        mDotLayout = findViewById(R.id.dotsLL);
        mSkip = findViewById(R.id.skipBtn);
        mPrev = findViewById(R.id.previousBtn);

        sliderAdapter = new SliderAdapter(this);
       mSlideViewpager.setAdapter(sliderAdapter);
        addDotIndicator(0);

        mSlideViewpager.addOnPageChangeListener(viewListener); //adding on change page listener to our page
    }

    // Button click logic
    public void prev(View view) {
        mSlideViewpager.setCurrentItem(mCurrentPage - 1);
    }

    public void skip(View view) {
     mSlideViewpager.setCurrentItem(mCurrentPage + 1);
     startActivity(new Intent(this,FoodList1.class));

        }

    }



