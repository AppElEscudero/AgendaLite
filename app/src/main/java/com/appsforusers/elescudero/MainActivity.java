package com.appsforusers.elescudero;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


import com.appsforusers.agendalite.CarritoFragment;
import com.appsforusers.elescudero.fragments.InsertFragment;
import com.appsforusers.elescudero.fragments.ListFragment;
import com.appsforusers.elescudero.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageButton btnCarrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnCarrito.setOnClickListener(this);

        setSupportActionBar(toolbar);
        setupNavigationView();

    }

    private void setupNavigationView(){

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        if(bottomNavigationView != null){

            // Select first menu item by default and show Fragment accordingly
            Menu menu = bottomNavigationView.getMenu();

            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    selectFragment(item);
                    return false;
                }
            });

        }

    }

    /**
     *
     * selectFragment Method
     * Purpose: Perform action when any item is selected
     *
     *
     * @param item -> Item that is selected
     */
    protected void selectFragment(MenuItem item){

        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.navigation_insert:
                // Action to perform when INSERT menu is selected
                pushFragment(new InsertFragment());
                break;
            case R.id.navigation_search:
                // Action to perform when SEARCH menu is selected
                pushFragment(new SearchFragment());
                break;
            case R.id.navigation_list:
                // Action to perform when LIST menu is selected
                pushFragment(new ListFragment());
                break;


        }

    }

    /**
     *
     * pushFragment Method
     * Purpose :  Method to push any fragment into give id
     *
     *
     * @param fragment -> An instance of fragment to show into the given id
     */
    public void pushFragment(Fragment fragment){

        if(fragment == null)
            return;

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager != null){
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(fragmentTransaction != null){
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.commit();
            }
        }

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCarrito:
                mostrarSuperCarrito();
                Log.d("TAG", "Hola carrito");
                break;

        }
    }

    private void mostrarSuperCarrito() {
        //pushFragment(new CarritoFragment());
        CarritoFragment carritoFragment = new CarritoFragment();
        carritoFragment.show(getSupportFragmentManager(), "Test");
    }
}
