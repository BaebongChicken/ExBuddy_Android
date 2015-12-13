package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.dataClass.InterestedActsData;

public class SignUp2Activity extends BaseActivity {

    private Button nextBtn;
    private ArrayList<Button> InterestedBtnArray = new ArrayList<Button>();
    public static int INTERESTED_ACTIVITY_COUNT = 4;
    private Button interestAct1Btn;
    private Button interestAct2Btn;
    private Button interestAct3Btn;
    private Button interestAct4Btn;
    public int interestActsCount = 0;

    public static ArrayList<InterestedActsData> interestedActsDataArray = new ArrayList<InterestedActsData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        setCustomActionbar();
        bindViews();
        setValues(R.string.signup2_title);
        setupEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setVisibilityByActsCount();
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
            }
        });

        for (int i = 0; i < INTERESTED_ACTIVITY_COUNT; i++) {
            final int mBtnNum = i;
            InterestedBtnArray.get(mBtnNum).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(getApplicationContext(), InterestedActsActivity.class);
                    if (interestedActsDataArray.size() != 0 && interestedActsDataArray.size() > mBtnNum) {
                        interestedActsDataArray.remove(mBtnNum);
                    }
                    Log.d("REQUEST_CODE", "" + mBtnNum);
                    mIntent.putExtra("mBtnNum", mBtnNum);
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

    private void setVisibilityByActsCount() {
        switch (interestActsCount) {
            case 0:
                for (int btnNum = 0; btnNum < 1; btnNum++) {
                    InterestedBtnArray.get(btnNum).setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                for (int btnNum = 0; btnNum < 2; btnNum++) {
                    InterestedBtnArray.get(btnNum).setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                for (int btnNum = 0; btnNum < 3; btnNum++) {
                    InterestedBtnArray.get(btnNum).setVisibility(View.VISIBLE);
                }
                break;
            case 3:
                for (int btnNum = 0; btnNum < 4; btnNum++) {
                    InterestedBtnArray.get(btnNum).setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    //임시구문을 위해 운동종목,레벨선택후 set텍스트구현
    private void setTextToBtn() {
        for (int i = 0; i < interestedActsDataArray.size(); i++) {
            Log.d("interetedActsDataArray", interestedActsDataArray.get(i).actsName + " , " + interestedActsDataArray.get(i).actsLevel);
            InterestedBtnArray.get(i).setText(interestedActsDataArray.get(i).actsName + "\n" + interestedActsDataArray.get(i).actsLevel);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("interestedActsDataArray", "resultCode is " + resultCode + ", requestCode is " + requestCode);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0:
                    setTextToBtn();
                    interestActsCount = 1;


                    Log.d("REQUEST_CODE", "(REQUEST_CODE)RECEIVED_3 : " + 0);
                    break;
                case 1:

                    setTextToBtn();


                    interestActsCount = 2;

                    Log.d("REQUEST_CODE", "(REQUEST_CODE)RECEIVED_3 : " + 1);

                    break;
                case 2:

                    setTextToBtn();

                    interestActsCount = 3;

                    Log.d("REQUEST_CODE", "(REQUEST_CODE)RECEIVED_3 : " + 2);

                    break;
                case 3:

                    setTextToBtn();

                    interestActsCount = 4;

                    Log.d("REQUEST_CODE", "(REQUEST_CODE)RECEIVED_3 : " + 3);

                    break;

            }
        }
    }
}
