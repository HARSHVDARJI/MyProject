package com.sunfusheng.StickyHeaderListView.model;

import java.io.Serializable;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class ChannelEntity implements Serializable {

    private String title;
    private Integer image_url;


    public ChannelEntity(String title, Integer image_url) {
        this.title = title;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImage_url() {
        return image_url;
    }

    public void setImage_url(Integer image_url) {
        this.image_url = image_url;
    }
}
