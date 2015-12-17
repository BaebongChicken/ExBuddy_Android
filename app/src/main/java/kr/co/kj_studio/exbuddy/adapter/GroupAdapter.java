package kr.co.kj_studio.exbuddy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.activities.MissionDetailActivity;
import kr.co.kj_studio.exbuddy.dataClass.GroupData;

/**
 * Created by KJ_Studio on 2015-12-08.
 */
public class GroupAdapter extends BaseCustomAdapter<GroupData>
{

    ArrayList<GroupData> mList;
    LayoutInflater inf;

    public GroupAdapter(Context context, ArrayList<GroupData> list) {
        super(context, R.layout.group_list_item, R.id.titleTxt, list);

        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.group_list_item, null);
            setGlobalFont(row);

        }
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(mContext, MissionDetailActivity.class);
                mContext.startActivity(mIntent);
            }
        });

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
