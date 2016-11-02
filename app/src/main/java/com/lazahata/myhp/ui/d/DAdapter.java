package com.lazahata.myhp.ui.d;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lazahata.myhp.App;
import com.lazahata.myhp.R;

/**
 * Created by dalizhang on 02/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class DAdapter extends RecyclerView.Adapter<DAdapter.DHolder> {


    @Override
    public DHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView t = new TextView(App.get());
        t.setText("jjjjj");
        t.setBackgroundColor(App.get().getResources().getColor(R.color.colorAccent));
        return new DHolder(t);
    }

    @Override
    public void onBindViewHolder(DHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class DHolder extends RecyclerView.ViewHolder {

        public DHolder(View itemView) {
            super(itemView);
        }


    }
}



