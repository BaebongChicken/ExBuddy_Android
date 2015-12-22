package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.MessageDigest;

import kr.co.kj_studio.exbuddy.R;

public class LoginActivity extends BaseActivity {


    Button facebookLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();

        getAppKeyHash();
    }


    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.d("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
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
