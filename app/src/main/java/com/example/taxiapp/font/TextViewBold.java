package com.example.taxiapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewBold extends androidx.appcompat.widget.AppCompatTextView {


    private Context context;

    private String name = "fonts/bold.ttf";

    public TextViewBold(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public TextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), name);
        this.setTypeface(font);

    }


}