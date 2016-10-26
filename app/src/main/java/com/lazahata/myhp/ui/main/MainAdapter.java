package com.lazahata.myhp.ui.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
        list.add(new LoginFragment());
        list.add(new DFragment());
        list.add(new LoginFragment());
        list.add(new DFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }
}
