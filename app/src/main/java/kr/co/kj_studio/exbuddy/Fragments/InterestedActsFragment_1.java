package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.activities.FragmentBaseActivity;

public class InterestedActsFragment_1 extends FragmentBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView();
    }

    void onCreateView(){
        layoutResId = R.layout.activity_interested_acts_fragment_1;
    }
}
