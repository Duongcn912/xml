package com.example.admin.demonavigationdrawer;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.TransitionDrawable;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img;
    TransitionDrawable transitionDrawable;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    Button btnClick;
    ListView mDrawerList;
    String[] mNavigationDrawerItemTitles;
    ArrayList<ObjectDrawerItem> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        InputStream inputStream=getResources().openRawResource(R.raw.hqdefault);
//        Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
//        img.setImageBitmap(bitmap);
//        transitionDrawable= (TransitionDrawable) img.getDrawable();
      //  toolbar=(Toolbar)findViewById(R.id.nav_actionbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        setSupportActionBar(toolbar);
        drawerLayout.addDrawerListener(drawerToggle);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

        mNavigationDrawerItemTitles=getResources().getStringArray(R.array.drawer_item);
        listItem=new ArrayList<ObjectDrawerItem>();
        for(int i=0;i<=2;i++){
            ObjectDrawerItem obj=new ObjectDrawerItem(mNavigationDrawerItemTitles[i],R.drawable.icon_next);
            listItem.add(obj);
        }

        DrawerCustomAdapter adapter=new DrawerCustomAdapter(this,R.layout.drawer_item_list,listItem);
        adapter.notifyDataSetChanged();
        mDrawerList=(ListView)findViewById(R.id.listItem);
        mDrawerList.setAdapter(adapter);




        navigationView=(NavigationView)findViewById(R.id.nvView);
        btnClick=(Button)findViewById(R.id.btnClick);
        btnClick.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                switch (id){
                    case R.id.search:{
                        Toast.makeText(MainActivity.this,"Sear",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                return true;
            }
        });
    }

//    @Override
//    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onPostCreate(savedInstanceState, persistentState);
//        drawerToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "About button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Help button selected", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this,hoso.class);
        startActivity(i);
    }
}
