package kr.co.kj_studio.exbuddy.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.utils.BackPressCloseHandler;

public class MainActivity extends BaseActivity {

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
        setValues(R.string.app_name, View.VISIBLE, View.VISIBLE);
        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
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

    @Override
    public void setValues(int title, int okView, int toggleView) {
        super.setValues(title, okView, toggleView);
        lvNavList.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public void bindViews() {
        super.bindViews();
        drawLayout = (LinearLayout) findViewById(R.id.drawLayout);
        dlDrawer = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);

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

        }
    }
}
