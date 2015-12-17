package kr.co.kj_studio.exbuddy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.activities.MissionDetailActivity;
import kr.co.kj_studio.exbuddy.dataClass.MissionData;

/**
 * Created by KJ_Studio on 2015-12-07.
 */
public class MissionAdapter extends BaseCustomAdapter<MissionData>
{


    ArrayList<MissionData> mList;
    LayoutInflater inf;

    public MissionAdapter(Context context, ArrayList<MissionData> list) {
        super(context, R.layout.mission_list_item_1, R.id.titleTxt, list);


        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (position % 2 == 1) {

            if (row == null) {
                row = inf.inflate(R.layout.mission_list_item_1, null);
                setGlobalFont(row);

            }
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext, MissionDetailActivity.class);
                    mContext.startActivity(mIntent);
                }
            });
        }
        else {

            if (row == null) {
                row = inf.inflate(R.layout.mission_list_item_2, null);
                setGlobalFont(row);

            }

            FrameLayout missionLayoutLeft = (FrameLayout) row.findViewById(R.id.missionLayoutLeft);
            missionLayoutLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent mIntent = new Intent(mContext, MissionDetailActivity.class);
                    mContext.startActivity(mIntent);
                }
            });

        }

        return row;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        return position % 2;
    }

    @Override
    public int getCount() {
        if (mList.size() % 3 == 0) {

            return mList.size() / 3 * 2;
        }
        else {

            return mList.size() / 3 * 2 +1;
        }
    }
}
