package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.kj_studio.exbuddy.R;

public class AdtlSignUpActivity extends BaseActivity {

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adtl_sign_up);
        setCustomActionbar();
        bindViews();
        setValues(R.string.signupadtl_title, View.VISIBLE);
        setupEvents();
    }

    @Override
    public void bindViews() {
        super.bindViews();
        nextBtn = (Button)findViewById(R.id.nextBtn);
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), SelectModeActivity.class);
                startActivity(mIntent);
                finish();
            }
        });
    }
}
