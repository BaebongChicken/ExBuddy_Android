package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;

import kr.co.kj_studio.exbuddy.R;

public class SignUp3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);


        setCustomActionbar();
        bindViews();
        setValues(R.string.signup3_title);
        setupEvents();
    }
}
