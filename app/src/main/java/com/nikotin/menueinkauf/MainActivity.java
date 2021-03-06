/**
 * Author: Dario Vieceli für das Team Einkauf Menu
 * Date: 9.4.2020
 * This is the Main Class to Navigate trough the Fragments
 *
 */

package com.nikotin.menueinkauf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationHost{
    public static final String LOG_TAG="DV-Einkauf";
    //static final String BASE_URL = "https://git.eclipse.org/r/"; // DV: für Github example
    public static final String BASE_URL ="https://ffhs-innt-my-menu.eu-gb.mybluemix.net/";
    private static MenuNormal selectedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_fragment);

        if (savedInstanceState == null) {
            navigateTo(new startFragment(),true);
        }
    }

    /**
     * Navigate to the given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"Main Activity has been Resume");
        navigateTo(new startFragment(),true);
    }
    public void setSelectedMenu(MenuNormal mn){
        selectedMenu=mn;
    }
    public MenuNormal getSelectedMenu(){
        return selectedMenu;
    }
}
