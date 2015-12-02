package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;

public class SignUpActivity extends BaseActivity {

    private Button nextBtn;
    private ArrayList<Button> InterestedBtnArray = new ArrayList<Button>();
    public static int INTERESTED_ACTIVITY_COUNT = 4;
    private Button InterestedBtn1;
    private Button InterestedBtn2;
    private Button InterestedBtn3;
    private Button InterestedBtn4;

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
                Intent mIntent = new Intent(getApplicationContext(), AdtlSignUpActivity.class);
                startActivity(mIntent);
                finish();
            }
        });

        for (int i = 0; i<INTERESTED_ACTIVITY_COUNT; i++){
            InterestedBtnArray.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(getApplicationContext(), InterestedActsActivity.class);
                    startActivity(mIntent);
                }
            });
        }
    }

    @Override
    public void bindViews() {
        super.bindViews();
        nextBtn = (Button) findViewById(R.id.nextBtn);

        InterestedBtn1 = (Button)findViewById(R.id.interestedBtn1);
        InterestedBtn2 = (Button)findViewById(R.id.interestedBtn2);
        InterestedBtn3 = (Button)findViewById(R.id.interestedBtn3);
        InterestedBtn4 = (Button)findViewById(R.id.interestedBtn4);
        setInterestedButtons();

    }

    private void setInterestedButtons(){
        InterestedBtnArray.add(InterestedBtn1);
        InterestedBtnArray.add(InterestedBtn2);
        InterestedBtnArray.add(InterestedBtn3);
        InterestedBtnArray.add(InterestedBtn4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
