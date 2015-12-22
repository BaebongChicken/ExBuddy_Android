package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.adapter.GroupAdapter;
import kr.co.kj_studio.exbuddy.adapter.MissionAdapter;
import kr.co.kj_studio.exbuddy.dataClass.GroupData;
import kr.co.kj_studio.exbuddy.dataClass.MissionData;

/**
 * Created by KJ_Studio on 2015-12-05.
 */
public class FindGroupFragment extends BaseFragment {

    ListView groupListView;
    ArrayList<GroupData> mGroupList = new ArrayList<>();

    FrameLayout lightningLayout;
    FrameLayout clubLayout;
    FrameLayout placeLayout;

    TextView lightningIndicator;
    TextView clubIndicator;
    TextView placeIndicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutResId = R.layout.fragment_find_group;
        View v = super.onCreateView(inflater, container, savedInstanceState);
        lightningLayout = (FrameLayout) v.findViewById(R.id.lightningLayout);
        clubLayout = (FrameLayout) v.findViewById(R.id.clubLayout);
        placeLayout = (FrameLayout) v.findViewById(R.id.placeLayout);
        groupListView = (ListView) v.findViewById(R.id.groupListView);

        lightningIndicator = (TextView) v.findViewById(R.id.lightningIndicator);
        clubIndicator = (TextView) v.findViewById(R.id.clubIndicator);
        placeIndicator = (TextView) v.findViewById(R.id.placeIndicator);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());
        mGroupList.add(new GroupData());

        groupListView.setAdapter(new GroupAdapter(getActivity(), mGroupList));

        setupEvents();
    }

    private void setupEvents() {
        lightningLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIndicators(0);
            }
        });
        clubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIndicators(1);
            }
        });
        placeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIndicators(2);
            }
        });
    }

    void setIndicators(int index) {

        if (index == 0) {

            lightningIndicator.setVisibility(View.VISIBLE);
            clubIndicator.setVisibility(View.GONE);
            placeIndicator.setVisibility(View.GONE);
        }
        else if (index == 1) {

            lightningIndicator.setVisibility(View.GONE);
            clubIndicator.setVisibility(View.VISIBLE);
            placeIndicator.setVisibility(View.GONE);
        }
        else if (index == 2) {

            lightningIndicator.setVisibility(View.GONE);
            clubIndicator.setVisibility(View.GONE);
            placeIndicator.setVisibility(View.VISIBLE);
        }
    }
}
