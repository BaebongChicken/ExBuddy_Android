package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.fragments.FindGroupFragment;
import kr.co.kj_studio.exbuddy.fragments.FindMemberFragment;
import kr.co.kj_studio.exbuddy.fragments.MissionsFragment;
import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.utils.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {

    private BackPressCloseHandler backPressCloseHandler;
    private DrawerLayout dlDrawer;
    private ListView lvNavList;
    LinearLayout drawLayout;
    private String[] navItems = {"Profile", "Mission", "Groups", "Members"};
    public ImageButton toggleBtn;
    public TextView mTitleTextView;


    ArrayList<Fragment> fragList = new ArrayList<Fragment>();
    Fragment currentFragment;

    LinearLayout fragment_mainContainer1;
    LinearLayout fragment_mainContainer2;
    LinearLayout fragment_mainContainer3;
    LinearLayout fragment_mainContainer4;
    LinearLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomActionbar();
        bindViews();
        setupEvents();
        setValues();

        addAllFrag();
    }


    void addAllFrag()
    {

        fragList.add(new MissionsFragment());
        fragList.add(new FindGroupFragment());
        fragList.add(new FindMemberFragment());

        final FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();

        ft.add(R.id.fragment_mainContainer1, fragList.get(0));
        ft.add(R.id.fragment_mainContainer2, fragList.get(1));
        ft.add(R.id.fragment_mainContainer3, fragList.get(2));

        currentFragment = fragList.get(0);
        currentLayout = fragment_mainContainer1;
        ft.commit();

    }

    public void setCustomActionbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
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

    public void setupEvents() {
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dlDrawer.isDrawerOpen(drawLayout)) {
                    dlDrawer.closeDrawer(drawLayout);
                } else {
                    dlDrawer.openDrawer(drawLayout);
                }
            }
        });

        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    public void setValues() {
        lvNavList.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());
        mTitleTextView.setText(R.string.app_name);
        toggleBtn.setVisibility(View.VISIBLE);
    }

    public void bindViews() {
        drawLayout = (LinearLayout) findViewById(R.id.drawLayout);
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);
        toggleBtn = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.toggleBtn);
        mTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.titleTxt);


        fragment_mainContainer1 = (LinearLayout) findViewById(R.id.fragment_mainContainer1);
        fragment_mainContainer2 = (LinearLayout) findViewById(R.id.fragment_mainContainer2);
        fragment_mainContainer3 = (LinearLayout) findViewById(R.id.fragment_mainContainer3);
        fragment_mainContainer4 = (LinearLayout) findViewById(R.id.fragment_mainContainer4);

    }

    @Override
    public void onBackPressed() {

        if (dlDrawer.isDrawerOpen(drawLayout)) {
            dlDrawer.closeDrawer(drawLayout);
        } else {
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

            if (position == 1) {

                currentLayout.setVisibility(View.GONE);
                fragment_mainContainer1.setVisibility(View.VISIBLE);
                currentLayout = fragment_mainContainer1;
            }
            else if (position == 2) {

                currentLayout.setVisibility(View.GONE);
                fragment_mainContainer2.setVisibility(View.VISIBLE);
                currentLayout = fragment_mainContainer2;
            }
            else if (position == 3) {

                currentLayout.setVisibility(View.GONE);
                fragment_mainContainer3.setVisibility(View.VISIBLE);
                currentLayout = fragment_mainContainer3;
            }


            dlDrawer.closeDrawer(drawLayout);
        }
    }
}
