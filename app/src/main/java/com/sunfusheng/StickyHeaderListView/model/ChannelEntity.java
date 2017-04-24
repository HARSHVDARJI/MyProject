package com.sunfusheng.StickyHeaderListView.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class ChannelEntity implements Serializable {

    /**
     * id : 1
     * cat_name : OS
     */

    private int id;
    private String cat_name;
    private int img;

    public ChannelEntity(int id, String cat_name, int img) {
        this.id = id;
        this.cat_name = cat_name;
        this.img = img;
    }


    public static ChannelEntity objectFromData(String str) {

        return new Gson().fromJson(str, ChannelEntity.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
