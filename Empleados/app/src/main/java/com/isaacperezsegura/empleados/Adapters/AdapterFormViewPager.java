package com.isaacperezsegura.empleados.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.isaacperezsegura.empleados.fragments.FormLaboralInformation;
import com.isaacperezsegura.empleados.fragments.FormPersonalInformation;

public class AdapterFormViewPager extends FragmentPagerAdapter {
    private Context context;
    private FormLaboralInformation formLaboralInformation;
    private FormPersonalInformation formPersonalInformation;

    public AdapterFormViewPager(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        formLaboralInformation = new FormLaboralInformation();
        formPersonalInformation = new FormPersonalInformation();
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return formPersonalInformation;
            case 1:
                return formLaboralInformation;
            default:
                return formPersonalInformation;
        }
    }
    public View getMyView(int i){
        switch(i){
            case 0:
                return formPersonalInformation.getMyView();
            case 1:
                return formLaboralInformation.getMyView();
            default:
                return formPersonalInformation.getMyView();
        }
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Personal";
            case 1:
                return "Laboral";
            default:
                return "Personal";
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}
