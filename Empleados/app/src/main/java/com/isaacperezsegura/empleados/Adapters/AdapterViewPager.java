package com.isaacperezsegura.empleados.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.isaacperezsegura.empleados.Modelo.Employee;
import com.isaacperezsegura.empleados.fragments.LaboralInformation;
import com.isaacperezsegura.empleados.fragments.PersonalInformation;

public class AdapterViewPager extends FragmentPagerAdapter{
    private Context context;
    private PersonalInformation personalInformation;
    private LaboralInformation laboralInformation;

    public AdapterViewPager(Context context, FragmentManager fm, Employee employee) {
        super(fm);
        this.context = context;
        personalInformation = new PersonalInformation();
        personalInformation.setEmployee(employee);
        laboralInformation = new LaboralInformation();
        laboralInformation.setEmployee(employee);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return personalInformation;
            case 1:
                return laboralInformation;
                default:
                    return personalInformation;
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
