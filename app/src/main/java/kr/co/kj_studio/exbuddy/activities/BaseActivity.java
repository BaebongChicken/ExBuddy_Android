package kr.co.kj_studio.exbuddy.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import kr.co.kj_studio.exbuddy.R;

/**
 * Created by JinHee on 2015-11-26.
 */
public class BaseActivity extends AppCompatActivity {

    public static TextView mTitleTextView;
    public static ImageButton okBtn;
    public static ImageButton toggleBtn;

    public void setupEvents() {

    }

    public void setupEvents(final Class<?> targetActivity) {
        final Class<?> mTargetActivity = targetActivity;
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), mTargetActivity);
                startActivity(mIntent);
                finish();
            }
        });
    }

    public void bindViews() {
        mTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.titleTxt);
        okBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.okBtn);
        toggleBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.toggleBtn);
    }

    public void setValues(int title) {
        mTitleTextView.setText(title);

    }

    public void setValues(int title, int okView) {
        mTitleTextView.setText(title);
        okBtn.setVisibility(okView);
    }

    public void setValues(int title, int okView, int toggleView) {
        mTitleTextView.setText(title);
        okBtn.setVisibility(okView);
        toggleBtn.setVisibility(toggleView);
    }





    public void setCustomActionbar() {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
//        return false;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
