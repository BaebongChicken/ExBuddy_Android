package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.kj_studio.exbuddy.R;

public class LoginActivity extends BaseActivity {


    Button facebookLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();

    }


    public void setupEvents() {
        facebookLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(mIntent);
                finish();
            }
        });
    }

    @Override
    public void bindViews() {
        facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
    }

}
