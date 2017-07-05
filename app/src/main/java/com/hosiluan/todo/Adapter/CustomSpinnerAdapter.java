package com.hosiluan.todo.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hosiluan.todo.Model.ListType;
import com.hosiluan.todo.R;

import java.util.ArrayList;

/**
 * Created by HoSiLuan on 7/3/2017.
 */

public class CustomSpinnerAdapter extends ArrayAdapter<ListType> {

    private Context mContext;
    private ArrayList<ListType> mListNames;

    public CustomSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ListType> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mListNames = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_spinner_default_item, parent, false);

        TextView listName =  convertView.findViewById(R.id.tv_list_name_default);

        ListType item = new ListType(mListNames.get(position).getmName());
        listName.setText(item.getmName());
        listName.setTypeface(null, Typeface.BOLD);

        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_spinner_item, parent, false);
        ListType item;

        TextView listName =  convertView.findViewById(R.id.tv_list_name);
        item = new ListType(mListNames.get(position).getmName());
        listName.setText(item.getmName());

        item =  mListNames.get(position);
        ImageView icon =  convertView.findViewById(R.id.img_icon);
        icon.setImageResource(item.getmIcon());

        return convertView;
    }

}
