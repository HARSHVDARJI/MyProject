package com.sunfusheng.StickyHeaderListView.model;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class ChannelEntity implements Serializable {
    String cat_name;
    int image;

    public ChannelEntity(String cat_name, int image) {
        this.cat_name = cat_name;
        this.image = image;
    }

    public String getCat_name() {
        Log.d("myapp", "catname "+ cat_name);
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getImage() {
        Log.d("myapp", "image "+ image);
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
