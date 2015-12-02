package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.Fragments.InterestedActsFragment_1;
import kr.co.kj_studio.exbuddy.Fragments.InterestedActsFragment_2;
import kr.co.kj_studio.exbuddy.R;

public class InterestedActsActivity extends BaseActivity {

    public ViewPager mViewPager;
    public PagerAdapter mPagerAdapter;
    public InterestedActsActivity mIAActivity;
    ArrayList<Fragment> fragList = new ArrayList<Fragment>();
    public InterestedActsFragment_1 InterestedActsFragment_1;
    public InterestedActsFragment_2 InterestedActsFragment_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_acts);
        setCustomActionbar();
        bindViews();
        setValues(R.string.ia_tile);
        setupEvents();
        setViewPager();

    }

    @Override
    public void bindViews() {
        super.bindViews();
        InterestedActsFragment_1 = new InterestedActsFragment_1();
        InterestedActsFragment_2 = new InterestedActsFragment_2();
        addFragments();
        mIAActivity = InterestedActsActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

    }

    public void setViewPager(){
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addFragments(){
        fragList.add(InterestedActsFragment_1);
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




