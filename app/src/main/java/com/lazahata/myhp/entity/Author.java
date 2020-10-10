package com.lazahata.myhp.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by lazahata on 15/2/2017.
 */

public class Author extends BaseObservable {

    @Bindable
    private String name;
    @Bindable
    private String href;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
