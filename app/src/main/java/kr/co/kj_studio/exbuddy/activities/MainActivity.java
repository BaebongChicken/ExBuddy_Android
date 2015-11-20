package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.utils.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {

    TextView mTitleTextView;
    ImageButton okBtn;
    ImageButton toggleBtn;


    private BackPressCloseHandler backPressCloseHandler;


    private DrawerLayout dlDrawer;
    private ListView lvNavList;
    LinearLayout drawLayout;
    private String[] navItems = {"Profile", "Mission", "Groups"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomActionbar();
        bindViews();
        setValues();
        setupEvents();
    }


    private void setupEvents() {

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dlDrawer.isDrawerOpen(drawLayout)) {
                    dlDrawer.closeDrawer(drawLayout);
                }
                else {
                    dlDrawer.openDrawer(drawLayout);
                }
            }
        });

        backPressCloseHandler = new BackPressCloseHandler(this);

    }

    private void setValues() {

        mTitleTextView.setText(R.string.app_name);
        okBtn.setVisibility(View.VISIBLE);
        toggleBtn.setVisibility(View.VISIBLE);


        lvNavList.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void bindViews() {

        mTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.titleTxt);
        okBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.okBtn);
        toggleBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.toggleBtn);

        drawLayout = (LinearLayout) findViewById(R.id.drawLayout);
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);

    }
    private void setCustomActionbar() {

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

    @Override
    public void onBackPressed() {

        if (dlDrawer.isDrawerOpen(drawLayout)) {
            dlDrawer.closeDrawer(drawLayout);
        }
        else {
            backPressCloseHandler.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position,
                                long id) {

        }
    }
}
