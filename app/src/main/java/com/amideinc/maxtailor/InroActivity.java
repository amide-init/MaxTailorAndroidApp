package com.amideinc.maxtailor;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class InroActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private int[] layouts = {R.layout.firstslide, R.layout.secondslide, R.layout.thirdslide, R.layout.fourthslide};
    private MpagerAdapter mpagerAdapter;
    private LinearLayout dots_layouts;
    private ImageView[] dots;
    Button btnSkip, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(new PreferenceManager(this).checkPreference())
        {
            loadHome();
        }
        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_inro);
        btnSkip = findViewById(R.id.bnSkip);
        btnNext = findViewById(R.id.bnNext);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        mpagerAdapter = new MpagerAdapter(layouts, InroActivity.this);
        viewPager.setAdapter(mpagerAdapter);

        dots_layouts = (LinearLayout)findViewById(R.id.dotslayout);
        btnSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if(position==layouts.length-1) {
                    btnNext.setText("Start");
                    btnSkip.setVisibility(View.INVISIBLE);
                } else {
                    btnNext.setText("Next");
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private  void createDots(int current_position)
    {
        if(dots_layouts != null)
            dots_layouts.removeAllViews();
        dots = new ImageView[layouts.length];

        for (int i = 0;  i<layouts.length; i++)
        {
            dots[i] = new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dots_layouts.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnSkip:
                loadHome();
                new PreferenceManager(this).writePrefence();
                break;
            case R.id.bnNext:
                nextSlide();
                break;
        }
    }
    private void loadHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private  void nextSlide() {
        int next_slide = viewPager.getCurrentItem() + 1;
         if(next_slide<layouts.length) {
             viewPager.setCurrentItem(next_slide);
         } else {
             loadHome();
             new PreferenceManager(this).writePrefence();
         }
    }
}
