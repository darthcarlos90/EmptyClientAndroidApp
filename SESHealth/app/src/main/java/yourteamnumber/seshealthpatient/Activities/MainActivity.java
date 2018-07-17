package yourteamnumber.seshealthpatient.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yourteamnumber.seshealthpatient.Fragments.PatientInformationFragment;
import yourteamnumber.seshealthpatient.R;


/**
 * Class: MainActivity
 * Extends:  {@link AppCompatActivity}
 * Author: Carlos Tirado < Carlos.TiradoCorts@uts.edu.au> and YOU!
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // More on this code, check the tutorial at http://www.vogella.com/tutorials/AndroidFragments/article.html
        FragmentManager fm = getFragmentManager();

        // Add the default Fragment once the user logged in
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, new PatientInformationFragment());
        ft.commit();
    }
}
