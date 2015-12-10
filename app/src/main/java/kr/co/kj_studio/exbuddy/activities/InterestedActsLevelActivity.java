package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import kr.co.kj_studio.exbuddy.R;

public class InterestedActsLevelActivity extends BaseActivity {

    private int currentBtnNum = 100;
    InterestedActsActivity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_act_level);
        currentBtnNum = getIntent().getIntExtra("mBtnNum", 0);
        Log.d("REQUEST_CODE", "(REQUEST_CODE)RECEIVED_2 : " + currentBtnNum);

        setCustomActionbar();
        bindViews();
        setValues(R.string.interestedactslevel_title);
        setupEvents(R.string.complete);

    }

    @Override
    public void setupEvents(int stateBtnText) {
        super.setupEvents(stateBtnText);
        stateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent mIntent = new Intent(getApplicationContext(),SignUp2Activity.class);
//                mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(mIntent);
//Flag로 하면 깔끔하지만, requestCode가 안넘어감.  finish를 직접날려줘야 리퀘스트코드가 반응하는듯
                finish();
                mContext.finish();

            }
        });
    }

    @Override
    public void bindViews() {
        super.bindViews();
        mContext = InterestedActsActivity.mIAActivity;
    }
}
