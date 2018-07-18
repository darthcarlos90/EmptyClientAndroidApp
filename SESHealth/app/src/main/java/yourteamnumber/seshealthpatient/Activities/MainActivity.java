package yourteamnumber.seshealthpatient.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import yourteamnumber.seshealthpatient.Fragments.DataPacketFragment;
import yourteamnumber.seshealthpatient.Fragments.HeartRateFragment;
import yourteamnumber.seshealthpatient.Fragments.MapFragment;
import yourteamnumber.seshealthpatient.Fragments.PatientInformationFragment;
import yourteamnumber.seshealthpatient.Fragments.RecordVideoFragment;
import yourteamnumber.seshealthpatient.Fragments.SendFileFragment;
import yourteamnumber.seshealthpatient.R;


/**
 * Class: MainActivity
 * Extends:  {@link AppCompatActivity}
 * Author:  Lord Avinash <avinash.singh@uts.edu.au>. Carlos Tirado < Carlos.TiradoCorts@uts.edu.au>, and YOU!
 * Description:
 * <p>
 * For this project I encourage you to use Fragments. It is up to you to build up the app as
 * you want, but it will be a good practice to learn on how to use Fragments. A very good tutorial
 * on how to use fragments can be found on this site: http://www.vogella.com/tutorials/AndroidFragments/article.html
 * <p>
 * I basically chose to use fragments because of the design of the app, again, you can choose to change
 * completely the design of the app, but for this design specifically I will use Fragments.
 * <p>
 * ___
 * _.-|   |          |\__/,|   (`\
 * {   |   |          |o o  |__ _) )
 * "-.|___|        _.( T   )  `  /
 * .--'-`-.     _((_ `^--' /_<  \
 * .+|______|__.-||__)`-'(((/  (((/
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;

    private static String TAG = "MainActivity";


    private enum MenuStates {
        PATIENT_INFO, DATA_PACKET, HEARTRATE, RECORD_VIDEO, SEND_FILE, NAVIGATION_MAP
    }

    private MenuStates currentState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentState = MenuStates.PATIENT_INFO;

        mDrawerLayout = findViewById(R.id.main_drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.nav_patient_info:
                                if (currentState != MenuStates.PATIENT_INFO) {
                                    ChangeFragment(new PatientInformationFragment());
                                    currentState = MenuStates.PATIENT_INFO;
                                }
                                break;
                            case R.id.nav_data_packet:
                                if (currentState != MenuStates.DATA_PACKET) {
                                    ChangeFragment(new DataPacketFragment());
                                    currentState = MenuStates.DATA_PACKET;
                                }
                                break;
                            case R.id.nav_heartrate:
                                if (currentState != MenuStates.HEARTRATE) {
                                    ChangeFragment(new HeartRateFragment());
                                    currentState = MenuStates.HEARTRATE;
                                }
                                break;
                            case R.id.nav_recordvideo:
                                if (currentState != MenuStates.RECORD_VIDEO) {
                                    ChangeFragment(new RecordVideoFragment());
                                    currentState = MenuStates.RECORD_VIDEO;
                                }
                                break;
                            case R.id.nav_sendfile:
                                if (currentState != MenuStates.SEND_FILE) {
                                    ChangeFragment(new SendFileFragment());
                                    currentState = MenuStates.SEND_FILE;
                                }
                                break;
                            case R.id.nav_map:
                                if (currentState != MenuStates.NAVIGATION_MAP) {
                                    ChangeFragment(new MapFragment());
                                    currentState = MenuStates.NAVIGATION_MAP;
                                }
                                break;
                        }

                        return true;
                    }
                });


        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );


        // More on this code, check the tutorial at http://www.vogella.com/tutorials/AndroidFragments/article.html
        fragmentManager = getFragmentManager();

        // Add the default Fragment once the user logged in
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, new PatientInformationFragment());
        ft.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This function changes the title of the fragment.
     *
     * @param newTitle The new title to write in the
     */
    public void ChangeTitle(String newTitle) {
        toolbar.setTitle(newTitle);
    }

    private void ChangeFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
