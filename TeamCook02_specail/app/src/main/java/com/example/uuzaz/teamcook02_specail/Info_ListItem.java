package com.example.uuzaz.teamcook02_specail;

import android.graphics.drawable.Drawable;

public class Info_ListItem {
    private int i_btnInt;
    private int iconInt;
    private String titleStr;
    private String d_dayStr;
    private String the_dayStr;

    public void setI_btn(int i_btn) { i_btnInt = i_btn; }

    public void setIcon(int icon) {
        iconInt = icon;
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



    public int getI_btn() { return this.i_btnInt; }

    public int getIcon() {
        return this.iconInt;
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
