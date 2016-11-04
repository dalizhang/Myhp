package com.lazahata.myhp.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by dalizhang on 03/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Thread extends BaseObservable {
    @Bindable
    private String title;
    @Bindable
    private String author;
    @Bindable
    private String replyCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }
}
