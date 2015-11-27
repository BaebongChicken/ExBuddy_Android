package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kr.co.kj_studio.exbuddy.R;

public class SignUpActivity extends BaseActivity {
//
//    public TextView mTitleTextView;
//    ImageButton okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setCustomActionbar();
        bindViews();
//        bindViews();
//        setValues();
        setValues(R.string.signup_title, View.VISIBLE, View.GONE);
        setupEvents(MainActivity.class);

    }

//
//    private void setupEvents() {
//
//        okBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent mIntent = new Intent(SignUpActivity.this, MainActivity.class);
//                startActivity(mIntent);
//                finish();
//            }
//        });
//
//
//    }
//
//    private void setValues() {
//
//        mTitleTextView.setText(R.string.signup_title);
//        okBtn.setVisibility(View.VISIBLE);
//
//    }

//    private void bindViews() {

//        mTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.titleTxt);
//        okBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.okBtn);
        
//    }
//    private void setCustomActionbar() {
//
//        ActionBar mActionBar = getSupportActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayHomeAsUpEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//        mActionBar.setDisplayShowCustomEnabled(true);
//        LayoutInflater mInflater = LayoutInflater.from(this);
//
//        View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);
//
//
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);
//
//        Toolbar parent = (Toolbar) mCustomView.getParent();
//        parent.setContentInsetsAbsolute(0, 0);
//    }


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
