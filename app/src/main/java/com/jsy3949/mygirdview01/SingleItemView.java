package com.jsy3949.mygirdview01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleItemView extends LinearLayout {

    TextView textView1;
    TextView textView2;
    ImageView imageView;

    public SingleItemView(Context context) {
        super(context);
        init(context);
    }

    public SingleItemView(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.single_item,this,true);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void setName(String name){
        textView1.setText(name);
    }

    public void setMobile(String mobile){
        textView2.setText(mobile);
    }

    public void setImg(int resId){
        imageView.setImageResource(resId);
    }

}
