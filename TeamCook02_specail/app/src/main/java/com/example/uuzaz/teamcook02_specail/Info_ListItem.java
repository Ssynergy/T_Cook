package com.example.uuzaz.teamcook02_specail;

import android.graphics.drawable.Drawable;

public class Info_ListItem {
    private Drawable i_btnDrawable;
    private Drawable iconDrawable;
    private String titleStr;
    private String d_dayStr;
    private String the_dayStr;


    public void setI_btn(Drawable i_btn) { i_btnDrawable = i_btn; }

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setThe_day(String the_day) {
        the_dayStr = the_day;
    }

    public void setD_day(String d_day) {
        d_dayStr = d_day;
    }

    public void setTitle(String title) {
        titleStr = title;
    }



    public Drawable getI_btn() { return this.i_btnDrawable; }

    public Drawable getIcon() {
        return this.iconDrawable;
    }

    public String getThe_day() {
        return this.the_dayStr;
    }

    public String getD_day() {
        return this.d_dayStr;
    }

    public String getTitle() {
        return this.titleStr;
    }
}

