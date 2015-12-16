package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.kj_studio.exbuddy.R;

public class SignUp4Activity extends BaseActivity {

    private Button signupPhotoBtn1;
    private Button signupPhotoBtn2;
    private Button signupPhotoBtn3;
    private Button signupPhotoBtn4;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);
        setCustomActionbar();
        bindViews();
        setValues(R.string.signup4_title);
        setupEvents();
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.startBtn = (Button) findViewById(R.id.startBtn);
        this.signupPhotoBtn4 = (Button) findViewById(R.id.signupPhotoBtn4);
        this.signupPhotoBtn3 = (Button) findViewById(R.id.signupPhotoBtn3);
        this.signupPhotoBtn2 = (Button) findViewById(R.id.signupPhotoBtn2);
        this.signupPhotoBtn1 = (Button) findViewById(R.id.signupPhotoBtn1);
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(),MainActivity.class);
                finishAllActivities();
                startActivity(mIntent);
//                finish();
            }
        });
    }
}
