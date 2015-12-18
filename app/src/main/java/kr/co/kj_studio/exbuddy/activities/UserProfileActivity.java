package kr.co.kj_studio.exbuddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.dataClass.UserData;

public class UserProfileActivity extends BaseActivity {

    UserData mUserData; // 보여줄 사용자의 정보를 들고있는 Data 클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setCustomActionbar();
        bindViews();
        setValues();
    }

    @Override
    public void setValues() {
        super.setValues();

        mTitleTextView.setText("Denis"); // 여기에 사용자 이름을 가져와야한다.
    }
}
