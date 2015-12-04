package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.kj_studio.exbuddy.R;

/**
 * Created by KJ_Studio on 2015-12-05.
 */
public class MissionsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutResId = R.layout.fragment_missions;
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
