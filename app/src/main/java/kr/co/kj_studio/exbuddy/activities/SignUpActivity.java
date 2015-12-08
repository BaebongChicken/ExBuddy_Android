package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.co.kj_studio.exbuddy.R;

public class SignUpActivity extends BaseActivity {

    private Button nextBtn;
    private Button yesBtn;
    private Button noBtn;
    private EditText nameEdt;
    private Button locationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setCustomActionbar();
        bindViews();
        setValues(R.string.signup_title);
        setupEvents();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), SignUp2Activity.class);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.nextBtn = (Button) findViewById(R.id.nextBtn);
        this.noBtn = (Button) findViewById(R.id.noBtn);
        this.yesBtn = (Button) findViewById(R.id.yesBtn);
        this.locationBtn = (Button) findViewById(R.id.locationBtn);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);

    }

}
