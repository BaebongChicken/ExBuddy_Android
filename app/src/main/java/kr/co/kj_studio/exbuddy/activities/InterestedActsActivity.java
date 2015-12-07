package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.Fragments.InterestedActs1Fragment;
import kr.co.kj_studio.exbuddy.Fragments.InterestedActs2Fragment;
import kr.co.kj_studio.exbuddy.R;

public class InterestedActsActivity extends BaseActivity {

    public ViewPager mViewPager;
    public PagerAdapter mPagerAdapter;
    public InterestedActsActivity mIAActivity;
    ArrayList<Fragment> fragList = new ArrayList<Fragment>();
    public InterestedActs1Fragment InterestedActs1Fragment;
    public InterestedActs2Fragment InterestedActsFragment_2;
    private Button sportsBtn;
    private Button fitnessBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_acts);


        setCustomActionbar();
        bindViews();
        setValues(R.string.InterestedActs_title);
        setupEvents();
        setViewPager();

    }

    @Override
    public void bindViews() {
        super.bindViews();
        InterestedActs1Fragment = new InterestedActs1Fragment();
        InterestedActsFragment_2 = new InterestedActs2Fragment();
        addFragments();
        mIAActivity = InterestedActsActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        this.fitnessBtn = (Button) findViewById(R.id.fitnessBtn);
        this.sportsBtn = (Button) findViewById(R.id.sportsBtn);

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        sportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });

        fitnessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });
    }

    public void setViewPager(){
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        sportsBtn.setBackgroundColor(getResources().getColor(R.color.color_background_white));
                        sportsBtn.setTextColor(getResources().getColor(R.color.color_text_primary));
                        fitnessBtn.setBackgroundColor(getResources().getColor(R.color.color_primary));
                        fitnessBtn.setTextColor(getResources().getColor(R.color.color_text_primary_inverse));
                        break;
                    case 1:
                        sportsBtn.setBackgroundColor(getResources().getColor(R.color.color_primary));
                        sportsBtn.setTextColor(getResources().getColor(R.color.color_text_primary_inverse));
                        fitnessBtn.setBackgroundColor(getResources().getColor(R.color.color_background_white));
                        fitnessBtn.setTextColor(getResources().getColor(R.color.color_text_primary));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addFragments(){
        fragList.add(InterestedActs1Fragment);
        fragList.add(InterestedActsFragment_2);
    }

    private class PageAdapter extends FragmentStatePagerAdapter {
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 해당하는 page의 Fragment를 생성합니다.
            Fragment finalFrag = null;
            finalFrag = fragList.get(position);
            return finalFrag;
        }

        @Override
        public int getCount() {
            return fragList.size();  // 총 .size()개의 page를 보여줍니다.
        }

    }
}




