package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.kj_studio.exbuddy.R;

/**
 * Created by KJ_Studio on 2015-12-23.
 */
public class MyWeexFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutResId = R.layout.fragment_myweexcercise;
        View v = super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }
}
