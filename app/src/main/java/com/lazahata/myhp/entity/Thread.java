package com.lazahata.myhp.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by dalizhang on 03/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Thread extends BaseObservable {
    @Bindable
    private String title;
    @Bindable
    private Author author;
    @Bindable
    private String replyCount;
    @Bindable
    private String href;
    @Bindable
    private String createdTime;
    @Bindable
    private String lastReplyTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(String lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
