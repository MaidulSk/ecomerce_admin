package in.maidul.ecomercegarments.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import in.maidul.ecomercegarments.R;
import in.maidul.ecomercegarments.fragment.CustomerPage;
import in.maidul.ecomercegarments.fragment.HomePage;
import in.maidul.ecomercegarments.fragment.OrderPage;
import in.maidul.ecomercegarments.fragment.ProductsPage;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout dl_drawer;
    private androidx.appcompat.widget.Toolbar tb_toolbar;
    private NavigationView nm_navigation;
    ActionBarDrawerToggle toogle;
    private TextView tv_header_text;
    Intent intent;

    private CardView cv_dashboard, cv_order, cv_products, cv_customer, cv_support, cv_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_dashboard);

        dl_drawer = findViewById(R.id.dl_drawer);
        tb_toolbar = findViewById(R.id.tb_toolbar);
        nm_navigation = findViewById(R.id.nm_navigation);
        cv_dashboard = findViewById(R.id.cv_dashboard);
        cv_order = findViewById(R.id.cv_order);
        cv_products = findViewById(R.id.cv_products);
        cv_customer = findViewById(R.id.cv_customer);
        cv_support = findViewById(R.id.cv_support);
        cv_return = findViewById(R.id.cv_return);
        tv_header_text = findViewById(R.id.tv_header_text);

        setSupportActionBar(tb_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tb_toolbar.setTitle("");
        tb_toolbar.setSubtitle("");

        toogle = new ActionBarDrawerToggle(this, dl_drawer, tb_toolbar, R.string.open, R.string.close);
        dl_drawer.addDrawerListener(toogle);
        toogle.syncState();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav_menu);

        nm_navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.change_password:
                        //  Toast.makeText(Dashboard.this, "Change Password.", Toast.LENGTH_SHORT).show();
                          intent = new Intent(Dashboard.this, UserProfile.class);
                        startActivity(intent);
                        dl_drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.item_return:
                        //  Toast.makeText(Dashboard.this, "Change Password.", Toast.LENGTH_SHORT).show();
                          intent = new Intent(Dashboard.this, ItemReturn.class);
                        startActivity(intent);
                        dl_drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });


        //for remove previos fragments all
        removePreviousFragment();
        //default action fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_body, new HomePage()); // add() method use two param, 1. where to paste, 2. whom to past
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        cv_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //for remove previos fragments all
                removePreviousFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fl_body, new HomePage()); // add() method use two param, 1. where to paste, 2. whom to past
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                tv_header_text.setText("Dashboard");

            }
        });

        cv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //for remove previos fragments all
                removePreviousFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fl_body, new OrderPage()); // add() method use two param, 1. where to paste, 2. whom to past
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                tv_header_text.setText("Orders");

            }
        });

        cv_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //for remove previos fragments all
                removePreviousFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fl_body, new ProductsPage()); // add() method use two param, 1. where to paste, 2. whom to past
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                tv_header_text.setText("Products");

            }
        });

        cv_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //for remove previos fragments all
                removePreviousFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fl_body, new CustomerPage()); // add() method use two param, 1. where to paste, 2. whom to past
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                tv_header_text.setText("Customers");

            }
        });

        cv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //for remove previos fragments all
//                removePreviousFragment();
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.add(R.id.fl_body, new ReturnPage()); // add() method use two param, 1. where to paste, 2. whom to past
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//                tv_header_text.setText("Returns");

                Intent intent = new Intent(Dashboard.this, ItemReturn.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void removePreviousFragment() {
        //for remove previos fragments all
        if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0) {

            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                Fragment fragment = getSupportFragmentManager().getFragments().get(i);
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }
            }
        }
    }

}