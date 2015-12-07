package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;

public class SignUp2Activity extends BaseActivity {

    private Button nextBtn;
    private ArrayList<Button> InterestedBtnArray = new ArrayList<Button>();
    public static int INTERESTED_ACTIVITY_COUNT = 4;
    private Button interestAct1Btn;
    private Button interestAct2Btn;
    private Button interestAct3Btn;
    private Button interestAct4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        setCustomActionbar();
        bindViews();
        setValues(R.string.signup2_title);
        setupEvents();

        Log.d("SignUp2", "find : " + mTitleTextView.getText());
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.nextBtn = (Button) findViewById(R.id.nextBtn);
        this.interestAct4Btn = (Button) findViewById(R.id.interestAct4Btn);
        this.interestAct3Btn = (Button) findViewById(R.id.interestAct3Btn);
        this.interestAct2Btn = (Button) findViewById(R.id.interestAct2Btn);
        this.interestAct1Btn = (Button) findViewById(R.id.interestAct1Btn);
        setInterestedButtons();

    }


    @Override
    public void setupEvents() {
        super.setupEvents();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), SignUp3Activity.class);
                startActivity(mIntent);
                finish();
            }
        });

        for (int i = 0; i < INTERESTED_ACTIVITY_COUNT; i++) {
            final int mBtnNum = i;
            InterestedBtnArray.get(mBtnNum).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(getApplicationContext(), InterestedActsActivity.class);
                    startActivityForResult(mIntent, mBtnNum);
                }
            });
        }
    }


    private void setInterestedButtons() {
        InterestedBtnArray.add(interestAct1Btn);
        InterestedBtnArray.add(interestAct2Btn);
        InterestedBtnArray.add(interestAct3Btn);
        InterestedBtnArray.add(interestAct4Btn);
    }
}
