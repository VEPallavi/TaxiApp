package com.example.taxiapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class EditTextLight extends androidx.appcompat.widget.AppCompatEditText {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;
    private String name = "fonts/light.ttf";

    public EditTextLight(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EditTextLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public EditTextLight(Context context, AttributeSet attrs, int defStyle) {
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