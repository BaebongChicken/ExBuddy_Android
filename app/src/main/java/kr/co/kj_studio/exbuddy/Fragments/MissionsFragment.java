package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.adapter.MissionAdapter;
import kr.co.kj_studio.exbuddy.dataClass.MissionData;

/**
 * Created by KJ_Studio on 2015-12-05.
 */
public class MissionsFragment extends BaseFragment {

    ListView missionListView;
    ArrayList<MissionData> mMissionList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutResId = R.layout.fragment_missions;
        View v = super.onCreateView(inflater, container, savedInstanceState);

        missionListView = (ListView) v.findViewById(R.id.missionListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());
        mMissionList.add(new MissionData());

        missionListView.setAdapter(new MissionAdapter(getActivity(), mMissionList));

    }
}
