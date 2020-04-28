package com.pandorax.coolnavigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;

import android.view.SubMenu;
import android.view.View;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment selectfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sNavigationDrawer = (SNavigationDrawer) findViewById(R.id.NavigationDrawer);

        // Menu add

        List<MenuItem> menuItems = new ArrayList<>();

        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.

        menuItems.add(new MenuItem("News",R.drawable.button_1_design));
        menuItems.add(new MenuItem("Feed",R.drawable.button_2_design));
        menuItems.add(new MenuItem("Messages",R.drawable.button_3_design));
        menuItems.add(new MenuItem("Music",R.drawable.button_4_design));
        menuItems.add(new MenuItem("Sport",R.drawable.button_5_design));
        menuItems.add(new MenuItem("Games",R.drawable.button_6_design));
        menuItems.add(new MenuItem("Books",R.drawable.button_7_design));
        menuItems.add(new MenuItem("Education",R.drawable.button_8_design));
        menuItems.add(new MenuItem("Tickets",R.drawable.button_9_design));
        menuItems.add(new MenuItem("E-commerce",R.drawable.button_11_design));
        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass = NewsFragment.class;

        try {
            selectfragment = (Fragment)fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        if(selectfragment!=null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                    android.R.animator.fade_out).replace(R.id.framelayout,selectfragment).commit();

        }



        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {

                try {
                    selectfragment = (Fragment)fragmentClass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }


                if(selectfragment!=null)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out).replace(R.id.framelayout,selectfragment).commit();

                }
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
