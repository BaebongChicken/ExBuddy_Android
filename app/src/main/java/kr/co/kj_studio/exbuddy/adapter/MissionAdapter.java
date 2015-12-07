package kr.co.kj_studio.exbuddy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.dataClass.MissionData;

/**
 * Created by KJ_Studio on 2015-12-07.
 */
public class MissionAdapter extends ArrayAdapter<MissionData>
{

    Context mContext;
    ArrayList<MissionData> mList;
    LayoutInflater inf;

    public MissionAdapter(Context context, ArrayList<MissionData> list) {
        super(context, R.layout.mission_list_item_1, R.id.titleTxt, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            if (position % 2 == 1) {
                row = inf.inflate(R.layout.mission_list_item_1, null);
            }
            else {

                row = inf.inflate(R.layout.mission_list_item_2, null);
            }
        }
        return row;
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
