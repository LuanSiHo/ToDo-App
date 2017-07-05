package com.hosiluan.todo.Model;

/**
 * Created by HoSiLuan on 7/4/2017.
 */

public class ListType {
    private int mIcon;
    private String mName;

    public ListType( String mName,int mIcon) {
        this.mIcon = mIcon;
        this.mName = mName;
    }

    public ListType(String mName) {
        this.mName = mName;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
