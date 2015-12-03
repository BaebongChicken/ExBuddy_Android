package kr.co.kj_studio.exbuddy.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.activities.FragmentBaseActivity;

public class InterestedActsFragment_1 extends FragmentBaseActivity {

    public LinearLayout selectionSportsLyt ;
    public String[] selectionSportsArray = {"soccer", "baseball", "boarding", "skydiving"};
    public ArrayList<Button> selectSportsBtnArray = new ArrayList<Button>();
    public ArrayList<LinearLayout> childViewArray = new ArrayList<LinearLayout>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        bindViews();
        makeSportsBtn();
        makeSportsLayout();
        Log.d("check arrays", "size of sports btn Array : " + selectSportsBtnArray.size());
        Log.d("check arrays", "size of child view Array : " + childViewArray.size());
        setButtonsInLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutResId = R.layout.activity_interested_acts_fragment_1;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    void bindViews() {
        selectionSportsLyt = (LinearLayout) getActivity().findViewById(R.id.selectionSportsLyt);
    }

    void makeSportsBtn() {
        LinearLayout.LayoutParams mBtnParams = new LinearLayout.LayoutParams(0, 100, 1);

        for (int j = 0; j < selectionSportsArray.length; j++) {
            Button mBtn = new Button(getActivity());
            mBtn.setLayoutParams(mBtnParams);
            mBtn.setId(j);
            mBtn.setText((j + 1) + " : " + selectionSportsArray[j]);
            mBtn.setBackgroundResource(R.color.color_primary);
            selectSportsBtnArray.add(mBtn);

        }
    }

    void makeSportsLayout() {
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int mPortion = ((int) (selectionSportsArray.length / 3) + 1);

        for (int i = 0; i < mPortion; i++) {
            LinearLayout mLayout = new LinearLayout(getActivity());
            mLayout.setLayoutParams(mParams);
            mLayout.setOrientation(LinearLayout.HORIZONTAL);
            childViewArray.add(mLayout);
        }
    }

    void setButtonsInLayout() {
        LinearLayout mLayout = new LinearLayout(getActivity());
        for (int l = 0; l < childViewArray.size(); l++) {
            LinearLayout mView = childViewArray.get(l);
            for (int k = 0; k < 3; k++) {
                if (selectSportsBtnArray.size()<(l*3+k)-1){
                    mView.addView(selectSportsBtnArray.get(l * 3 + k));
                    Log.d("check arrays", "setButtonsInLayout processing..." + "terms : " + l + " , " + k);
                }
            }
            mLayout.addView(mView);
        }
        selectionSportsLyt = mLayout;
    }
}
