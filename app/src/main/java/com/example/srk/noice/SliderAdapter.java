package com.example.srk.noice;
/**Add content and layout inflater variables
 * Create a constructor to pass context through it
 * Create arrays to store the values for our slider
 * override instantiateItem
 * override destroyItem*/
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) { // constructor
        this.context = context;
    }

    //Arrays
    public int [] slide_images ={
            R.drawable.notice,
            R.drawable.chatbot,

    };
    public String[] slide_headings ={
            "NOTICE",
            "CHATBOT",

    };
    public  String [] side_desc = {
            "The Digital Notice Board is an exciting new innovative way to get information to you.",
            "A chatbot is a computer program or an artificial intelligence which conducts a conversation via auditory or textual methods.",

    };


 /**Add background array if you are using different backgrounds*/

    @Override
    public int getCount() {
        return slide_headings.length; //count is equal to number of heading
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object; // change to constraint layout
    }

    @NonNull
    @Override
    //required to give those side effects and inflate all of these in this adapter
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

            //initialize views
            ImageView slideImage = view.findViewById(R.id.imageIV);
            TextView slideHeading  = view.findViewById(R.id.headingTV);
            TextView slideDesc  = view.findViewById(R.id.descTV);

            //setting values
            slideImage.setImageResource(slide_images[position]); // the current position of side will pass to it and it will set image automatically
            slideHeading.setText(slide_headings[position]);
            slideDesc.setText(side_desc[position]);

            container.addView(view);
            return view;
    }

    @Override
    //when we reach last page it will then stop
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
