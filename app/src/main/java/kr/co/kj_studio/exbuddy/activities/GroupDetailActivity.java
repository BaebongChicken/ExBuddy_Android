package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.kj_studio.exbuddy.R;

public class GroupDetailActivity extends BaseActivity {

    private android.widget.TextView groupNameTxt;
    private android.widget.TextView numOfMemberTxt;
    private android.widget.TextView hostMessageTxt;
    private android.widget.LinearLayout pageControllerLayout;
    private android.widget.TextView dateAndTimeTxt;
    private android.widget.TextView locationTxt;
    private android.widget.ImageView checkAllMemberImageView;
    private android.widget.FrameLayout googleMapLayout;
    private android.widget.LinearLayout replyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        // 살려놨땅!!

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.replyLayout = (LinearLayout) findViewById(R.id.replyLayout);
        this.googleMapLayout = (FrameLayout) findViewById(R.id.googleMapLayout);
        this.checkAllMemberImageView = (ImageView) findViewById(R.id.checkAllMemberImageView);
        this.locationTxt = (TextView) findViewById(R.id.locationTxt);
        this.dateAndTimeTxt = (TextView) findViewById(R.id.dateAndTimeTxt);
        this.pageControllerLayout = (LinearLayout) findViewById(R.id.pageControllerLayout);
        this.hostMessageTxt = (TextView) findViewById(R.id.hostMessageTxt);
        this.numOfMemberTxt = (TextView) findViewById(R.id.numOfMemberTxt);
        this.groupNameTxt = (TextView) findViewById(R.id.groupNameTxt);

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        checkAllMemberImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(GroupDetailActivity.this, moreBtn);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popupmenu_for_group, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals(getResources().getString(R.string.report))) {
                            Toast.makeText(GroupDetailActivity.this, "신고 접수 기능을 구현합니다.", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public void setValues() {
        super.setValues();
        moreBtn.setVisibility(View.VISIBLE);
    }
}
