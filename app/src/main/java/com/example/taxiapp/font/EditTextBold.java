package com.example.taxiapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class EditTextBold extends androidx.appcompat.widget.AppCompatEditText {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;
    private String name = "fonts/bold.ttf";

    public EditTextBold(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EditTextBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public EditTextBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), name);
        this.setTypeface(font);
    }


}