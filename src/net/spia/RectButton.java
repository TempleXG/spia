package net.spia;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RectButton extends Button {

	public RectButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf3");
		}});
	}
	
	public RectButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf2");
		}});
		Log.i("asdf",attrs.toString());
		this.setBackgroundColor(Color.BLUE);
		
		//this.fhgkjdfhjkdfj ÀÌ»Ú°Ô
	}
	
	public RectButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf1");
		}});
	}
}