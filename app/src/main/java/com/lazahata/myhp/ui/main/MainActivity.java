package com.lazahata.myhp.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ActivityMainBinding;
import com.lazahata.myhp.utils.Log;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.viewpager.setAdapter(new MainAdapter(getSupportFragmentManager()));
    }

    public void toFirstTab(View view) {
        Log.i("test", "toFirstTab");
        binding.viewpager.setCurrentItem(0);
    }

    public void toSecondTab(View view) {
        Log.i("test", "toSecondTab");
        binding.viewpager.setCurrentItem(1);
    }

    public void toThirdTab(View view) {
        Log.i("test", "toThirdTab");
        binding.viewpager.setCurrentItem(2);
    }

    public void toFourthTab(View view) {
        Log.i("test", "toFourthTab");
        binding.viewpager.setCurrentItem(3);
    }

}
