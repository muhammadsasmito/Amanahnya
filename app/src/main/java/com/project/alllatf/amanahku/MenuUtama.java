package com.project.alllatf.amanahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;
import com.project.alllatf.amanahku.Fragment.MenuUtama.PemberitahuanFragment;
import com.project.alllatf.amanahku.Fragment.MenuUtama.PembiayaanFragment;
import com.project.alllatf.amanahku.Fragment.MenuUtama.TimeLineFragment;
import com.project.alllatf.amanahku.Fragment.OnFragmentInteractionListener;
import com.project.alllatf.amanahku.Model.MenuUtama.PemberitahuanModel;

import java.util.Calendar;

public class MenuUtama extends AppCompatActivity implements OnFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mSectionsPagerAdapter.getTabView(i));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabPesanBrg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuUtama.this,PesanBrg.class);
                startActivity(i);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_utama, menu);
        return true;
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

    @Override
    public void onFragmentInteraction(String TAG, Object data) {
        if (TAG.equals("PemberitahuanRecycleViewAdapter")){
            PemberitahuanModel.PemberitahuanItem item = (PemberitahuanModel.PemberitahuanItem) data;
            Toast.makeText(MenuUtama.this,"Di klik "+item.details,Toast.LENGTH_SHORT).show();
        } else if (TAG.equals("TimeLineFragment")){
            if (data instanceof CalendarEvent){
                CalendarEvent item = (CalendarEvent) data;
                Toast.makeText(MenuUtama.this,"Di klik "+item.getTitle(),Toast.LENGTH_SHORT).show();
            } else if (data instanceof DayItem){
                DayItem item = (DayItem) data;
                Toast.makeText(MenuUtama.this,"Di klik "+item.getValue(),Toast.LENGTH_SHORT).show();
            } else if (data instanceof Calendar){
                Calendar item = (Calendar) data;
                Toast.makeText(MenuUtama.this,"Di scroll ke"+item.getFirstDayOfWeek(),Toast.LENGTH_SHORT).show();


            }
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String[] tabTitles = new String[] {"Pemberitahuan", "Lini Waktu"};
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(MenuUtama.this).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return PemberitahuanFragment.newInstance(position);
                case 1:
                    return TimeLineFragment.newInstance("Param1","Param2");
            }
            return null;
            //return PembiayaanFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
            //return null;
        }
    }
}
