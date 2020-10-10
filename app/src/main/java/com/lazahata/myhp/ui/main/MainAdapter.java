package com.lazahata.myhp.ui.main;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lazahata.myhp.ui.d.DFragment;

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
        list.add(new DFragment());
        list.add(new FFragment());
        list.add(new HFragment());
        list.add(new MeFragment());
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
