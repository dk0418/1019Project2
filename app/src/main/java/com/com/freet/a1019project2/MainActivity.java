package com.com.freet.a1019project2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.com.freet.a1019project2.fragment.Fragment_Allmenu;
import com.com.freet.a1019project2.fragment.Fragment_Home;
import com.com.freet.a1019project2.fragment.Fragment_Intcall;
import com.com.freet.a1019project2.fragment.Fragment_Mypage;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity
{
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager)findViewById(R.id.main_viewPager);

        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        disableShiftMode(navigation);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
                {

                }

                @Override
                public void onPageSelected(int position)
                {
                    MenuItem menuItem = navigation.getMenu().getItem(position);
                    menuItem.setChecked(true);
                }

                @Override
                public void onPageScrollStateChanged(int state)
                {

                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.title_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_bt1:
                Toast.makeText(this, "로그인해주세요", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vp.setCurrentItem(0);
                    return true;
                case R.id.navigation_allmenu:
                    vp.setCurrentItem(1);
                    return true;
                case R.id.navigation_intcall:
                    vp.setCurrentItem(2);
                    return true;
                case R.id.navigation_mypage:
                    vp.setCurrentItem(3);
                    return true;
            }

            return false;
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter {

        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    return new Fragment_Home();

                case 1:
                    return new Fragment_Allmenu();

                case 2:
                    return new Fragment_Intcall();

                case 3:
                    return new Fragment_Mypage();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public static void disableShiftMode(BottomNavigationView view)
    {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);

        try{
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for(int i = 0; i < menuView.getChildCount(); i++){
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);

                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
