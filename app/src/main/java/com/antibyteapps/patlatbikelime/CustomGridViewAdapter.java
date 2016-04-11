package com.antibyteapps.patlatbikelime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ykarabalkan on 09.04.2016.
 */
public class CustomGridViewAdapter extends BaseAdapter {
    private Context context;
    private static LayoutInflater inflater = null;
    public static String[] result = {"A", "B", "C", "Ç", "D", "E", "F", "G", "Ğ", "H", "I", "İ", "J", "K", "L", "M", "N", "O", "Ö", "P", "R", "S", "Ş", "T", "U"};

    public CustomGridViewAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final View rowView = inflater.inflate(R.layout.grid_list, null);
        final Item holder = new Item((TextView) rowView.findViewById(R.id.textView1), null, null);
        holder.getTextView().setText(result[position]);

        return rowView;
    }
}
