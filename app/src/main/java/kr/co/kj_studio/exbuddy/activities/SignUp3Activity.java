package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.kj_studio.exbuddy.R;

public class SignUp3Activity extends BaseActivity {

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);


        setCustomActionbar();
        bindViews();
        setValues(R.string.signup3_title);
        setupEvents();
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.nextBtn = (Button) findViewById(R.id.nextBtn);

    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
