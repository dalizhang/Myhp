package com.lazahata.myhp.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ActivityMainBinding;
import com.lazahata.myhp.utils.Log;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "onCreate");
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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
