package net.spia;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ImageButton extends Button {
	private StateListDrawable _imageDraw;
	private Drawable btn_pressed;
	private Drawable btn_normal;
	
	public ImageButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf3");
		}});
		init();
	}
	
	public ImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf2");
		}});
		Log.i("asdf",attrs.toString());
		init();
		//this.fhgkjdfhjkdfj ÀÌ»Ú°Ô
	}
	
	public ImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("asdf","asdf1");
		}});
		init();
	}
	
	public void setNormalImage(int id)
	{
		_imageDraw = new StateListDrawable();

	    btn_normal = this.getResources().getDrawable(id);
	    
		_imageDraw.addState(new int[] { android.R.attr.state_pressed }, btn_pressed);
		_imageDraw.addState(new int[] { -android.R.attr.state_pressed }, btn_normal);
		if(Build.VERSION.SDK_INT >= 16) {
			this.setBackground(_imageDraw);
		} else {
			this.setBackgroundDrawable(_imageDraw);
		}
	}
	
	public void setPressedImage(int id)
	{
		_imageDraw = new StateListDrawable();
		btn_pressed = new BitmapDrawable(this.getResources(), this.getBitmap("btn_default_.png"));
		_imageDraw.addState(new int[] { android.R.attr.state_pressed }, btn_pressed);
		_imageDraw.addState(new int[] { -android.R.attr.state_pressed }, btn_normal);
		if(Build.VERSION.SDK_INT >= 16) {
			this.setBackground(_imageDraw);
		} else {
			this.setBackgroundDrawable(_imageDraw);
		}
	}
	
	private void init(){
		_imageDraw = new StateListDrawable();
		btn_pressed = new BitmapDrawable(this.getResources(), this.getBitmap("btn_default_.png"));
		btn_normal = new BitmapDrawable(this.getResources(), this.getBitmap("btn_default.png"));
		_imageDraw.addState(new int[] { android.R.attr.state_pressed }, btn_pressed);
		_imageDraw.addState(new int[] { -android.R.attr.state_pressed }, btn_normal);
        if(Build.VERSION.SDK_INT >= 16) {
			this.setBackground(_imageDraw);
		} else {
			this.setBackgroundDrawable(_imageDraw);
		}
	}
	
	private Bitmap getBitmap(String filename) {
		Bitmap bitmap = null;
		try {
			InputStream is = this.getResources().getAssets().open(filename); 
			bitmap = BitmapFactory.decodeStream(is);
		} catch (Exception e) {} 
		
		return bitmap;
	}
}