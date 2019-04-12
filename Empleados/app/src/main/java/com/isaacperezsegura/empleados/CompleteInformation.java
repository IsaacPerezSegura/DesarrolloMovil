package com.isaacperezsegura.empleados;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.isaacperezsegura.empleados.Adapters.AdapterViewPager;
import com.isaacperezsegura.empleados.Modelo.Employee;

public class CompleteInformation extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterViewPager viewPagerAdapter;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        employee = (Employee) getIntent().getSerializableExtra("employee");

        viewPagerAdapter = new AdapterViewPager(this, getSupportFragmentManager(), employee);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
    public void previusActivity(View view){
        super.onBackPressed();
        finish();
    }
}
