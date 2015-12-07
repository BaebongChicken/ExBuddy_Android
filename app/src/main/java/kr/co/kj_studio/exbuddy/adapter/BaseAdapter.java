package kr.co.kj_studio.exbuddy.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;

/**
 * Created by KJ_Studio on 2015-12-08.
 */
public abstract class BaseAdapter extends ArrayAdapter {
    public BaseAdapter(Context context, ArrayList list) {
        super(context, R.layout.group_list_item, R.id.titleTxt, list);
    }
}
