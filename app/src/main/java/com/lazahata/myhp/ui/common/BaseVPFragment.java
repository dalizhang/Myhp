package com.lazahata.myhp.ui.common;

import androidx.fragment.app.Fragment;

/**
 * Created by lazahata on 13/2/2017.
 */

public abstract class BaseVPFragment extends Fragment {


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isVisible()) {
            onRealResume();
        } else {
            onRealPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            onRealResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onRealPause();
        }
    }

    /**
     * Used with viewpager will change the lifecycle behaviour of fragments,
     * this is a trick to get back the 'normal' lifecycle.
     */
    protected abstract void onRealResume();

    protected abstract void onRealPause();
}
