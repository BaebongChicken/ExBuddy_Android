package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;

import kr.co.kj_studio.exbuddy.R;

public class InterestedActs2Fragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView();
    }

    void onCreateView(){
        layoutResId = R.layout.fragment_interested_acts2;
    }
}
