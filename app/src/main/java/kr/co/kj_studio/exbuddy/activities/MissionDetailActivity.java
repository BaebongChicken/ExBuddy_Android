package kr.co.kj_studio.exbuddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import kr.co.kj_studio.exbuddy.R;

public class MissionDetailActivity extends BaseActivity {

    LinearLayout commentsLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_detail);

        bindViews();

        loadComments();
        setValues(R.string.missiondetail_title);
    }

    private void loadComments() {
        LayoutInflater inf = LayoutInflater.from(MissionDetailActivity.this);
        commentsLinearLayout.removeAllViews();
        for (int i =0; i < 10; i++) {
            View v = inf.inflate(R.layout.comment_list_item, null);
            commentsLinearLayout.addView(v);
        }
    }

    @Override
    public void bindViews() {
        super.bindViews();
        commentsLinearLayout = (LinearLayout) findViewById(R.id.commentsLinearLayout);
    }
}
