package com.antibyteapps.patlatbikelime;

import android.graphics.Bitmap;
import android.widget.TextView;

/**
 * Created by ykarabalkan on 09.04.2016.
 */
public class Item {
    TextView textView;
    Bitmap image;
    String title;

    public Item(TextView textView, Bitmap image, String title) {
        this.textView = textView;
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
