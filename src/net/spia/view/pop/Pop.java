package net.spia.view.pop;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class Pop extends PopView{
	private final Context context;
	private final LayoutInflater inflater;
	private final View root;
	//private ViewGroup mTrack;
	private View content;
	
	private TextView title;
	private TextView question;
	private EditText edit;
	public Button Btn_Yes;
	public Button Btn_No;
	
	private int width = 280;
	private int height = 360;
	public Pop(View anchor, int id)
	{
		super(anchor);
		context = anchor.getContext();
		
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//root = (ViewGroup)inflater.inflate(R.layout.pop, null);
		
		/*
		LinearLayout linear = (LinearLayout)root.findViewById(R.id.pop_content);
		TextView text = new TextView(context);
		text.setText("Popup Window!");
		text.setGravity(Gravity.CENTER);
		text.setTextColor(Color.CYAN);
		text.setTextSize(20);
		linear.addView(text);

		Button btn_close = (Button)root.findViewById(R.id.Btn_close);
		btn_close.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				dismiss();
			}
		});
		*/
		//setContentView(root);
		
		
		//mTrack = (ViewGroup)root.findViewById(R.id.viewRow);
		
		LinearLayout linear = new LinearLayout(context);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.argb(155, 0, 0, 0));
		linear.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		linear.setGravity(0x11);
		
		//ScrollView sView = new ScrollView(context);
		//sView.setBackgroundColor(Color.LTGRAY);
		//sView.setMinimumWidth(400);
		//sView.setMinimumHeight(400);
		
		LinearLayout border = new LinearLayout(context);
		border.setOrientation(LinearLayout.VERTICAL);
		border.setBackgroundColor(Color.BLACK);
		border.setLayoutParams(new LinearLayout.LayoutParams(getPixel(width)+4, getPixel(height)+4));
		border.setGravity(0x11);
		
		LinearLayout inner = new LinearLayout(context);
		inner.setLayoutParams(new LinearLayout.LayoutParams(getPixel(width), getPixel(height)));
		inner.setOrientation(LinearLayout.VERTICAL);
		inner.setBackgroundColor(0xffffffff);
		inner.setGravity(0x11);


		content = (ViewGroup)inflater.inflate(id, null);
		
		inner.addView(content);
		border.addView(inner);
		linear.addView(border);
		root = (ViewGroup)linear;
		setContentView(root);
	}
	
	public View getView(){
		return content;
	}
	public Pop(View anchor){
		super(anchor);
		context = anchor.getContext();
		
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//root = (ViewGroup)inflater.inflate(R.layout.pop, null);
		
		/*
		LinearLayout linear = (LinearLayout)root.findViewById(R.id.pop_content);
		TextView text = new TextView(context);
		text.setText("Popup Window!");
		text.setGravity(Gravity.CENTER);
		text.setTextColor(Color.CYAN);
		text.setTextSize(20);
		linear.addView(text);

		Button btn_close = (Button)root.findViewById(R.id.Btn_close);
		btn_close.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				dismiss();
			}
		});
		*/
		//setContentView(root);
		
		
		//mTrack = (ViewGroup)root.findViewById(R.id.viewRow);
		
		LinearLayout linear = new LinearLayout(context);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.argb(155, 0, 0, 0));
		linear.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		linear.setGravity(0x11);
		
		//ScrollView sView = new ScrollView(context);
		//sView.setBackgroundColor(Color.LTGRAY);
		//sView.setMinimumWidth(400);
		//sView.setMinimumHeight(400);
		
		LinearLayout border = new LinearLayout(context);
		border.setOrientation(LinearLayout.VERTICAL);
		border.setBackgroundColor(Color.WHITE);
		border.setLayoutParams(new LinearLayout.LayoutParams(getPixel(280)+4, getPixel(360)+4));
		border.setGravity(0x11);
		
		LinearLayout inner = new LinearLayout(context);
		inner.setLayoutParams(new LinearLayout.LayoutParams(getPixel(280), getPixel(360)));
		inner.setOrientation(LinearLayout.VERTICAL);
		inner.setBackgroundColor(0xff444444);
		inner.setGravity(0x11);
		
		
		
		LinearLayout header = new LinearLayout(context);
		header.setOrientation(LinearLayout.VERTICAL);
		header.setLayoutParams(new LinearLayout.LayoutParams(getPixel(280), getPixel(90)));
		header.setGravity(0x11);
		header.setPadding(getPixel(10), getPixel(10), getPixel(10), getPixel(10));
		
		title = new TextView(context);
		title.setText("");
		title.setGravity(Gravity.CENTER);
		title.setTextColor(Color.WHITE);
		title.setTextSize(getPixel(15));
		header.addView(title);
		
		ImageView img_line = new ImageView(context);
		if(Build.VERSION.SDK_INT >= 16) {
			Drawable d = new BitmapDrawable(anchor.getResources(), this.getBitmap("pop_line.png"));
			img_line.setBackground(d);
		} else {
			img_line.setBackgroundDrawable(new BitmapDrawable(this.getBitmap("pop_line.png")));
		}
		header.addView(img_line);
		
		question = new TextView(context);
		question.setLayoutParams(new LinearLayout.LayoutParams(getPixel(200), getPixel(40)));
		question.setText("");
		question.setGravity(Gravity.CENTER);
		question.setTextColor(Color.WHITE);
		question.setTextSize(getPixel(8));
		header.addView(question);
		
		LinearLayout content = new LinearLayout(context);
		content.setOrientation(LinearLayout.HORIZONTAL);
		content.setLayoutParams(new LinearLayout.LayoutParams(getPixel(260), getPixel(210)));
		content.setGravity(0x11);
		//content.setBackgroundColor(Color.WHITE);
		
		edit = new EditText(context);
		edit.setLayoutParams(new LinearLayout.LayoutParams(getPixel(260), getPixel(210)));
		edit.setSingleLine(false);
		
		if(Build.VERSION.SDK_INT >= 16) {
			Drawable d = new BitmapDrawable(anchor.getResources(), this.getBitmap("pop_form.png"));
			edit.setBackground(d);
		} else {
			edit.setBackgroundDrawable(new BitmapDrawable(this.getBitmap("pop_form.png")));
		}
		content.addView(edit);
		
		
		LinearLayout btns = new LinearLayout(context);
		btns.setOrientation(LinearLayout.HORIZONTAL);
		btns.setLayoutParams(new LinearLayout.LayoutParams(getPixel(280), getPixel(60)));
		btns.setGravity(0x11);

		Btn_Yes = new Button(context);
		Btn_Yes.setLayoutParams(new LinearLayout.LayoutParams(getPixel(129), getPixel(40)));

		StateListDrawable btn_yes_imageDraw = new StateListDrawable();
		Drawable btn_yes_click = new BitmapDrawable(anchor.getResources(), this.getBitmap("btn_pop_yes_click.png"));
		Drawable btn_yes = new BitmapDrawable(anchor.getResources(), this.getBitmap("btn_pop_yes.png"));
		btn_yes_imageDraw.addState(new int[] { android.R.attr.state_pressed }, btn_yes_click);
		btn_yes_imageDraw.addState(new int[] { -android.R.attr.state_pressed }, btn_yes);
        if(Build.VERSION.SDK_INT >= 16) {
			Btn_Yes.setBackground(btn_yes_imageDraw);
		} else {
			Btn_Yes.setBackgroundDrawable(btn_yes_imageDraw);
		}
		Btn_Yes.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dismiss();
		}});
		btns.addView(Btn_Yes);
		
		ImageView blank = new ImageView(context);
		blank.setLayoutParams(new LinearLayout.LayoutParams(getPixel(2), getPixel(40)));
		blank.setBackgroundColor(Color.TRANSPARENT);
		btns.addView(blank);
		
		Btn_No = new Button(context);
		Btn_No.setLayoutParams(new LinearLayout.LayoutParams(getPixel(129), getPixel(40)));
		
		StateListDrawable btn_no_imageDraw = new StateListDrawable();
		Drawable btn_no_click = new BitmapDrawable(anchor.getResources(), this.getBitmap("btn_pop_no_click.png"));
		Drawable btn_no = new BitmapDrawable(anchor.getResources(), this.getBitmap("btn_pop_no.png"));
		btn_no_imageDraw.addState(new int[] { android.R.attr.state_pressed }, btn_no_click);
		btn_no_imageDraw.addState(new int[] { -android.R.attr.state_pressed }, btn_no);
        if(Build.VERSION.SDK_INT >= 16) {
        	Btn_No.setBackground(btn_no_imageDraw);
		} else {
			Btn_No.setBackgroundDrawable(btn_no_imageDraw);
		}
		Btn_No.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dismiss();
		}});
		btns.addView(Btn_No);
		
		
		inner.addView(header);
		inner.addView(content);
		inner.addView(btns);
		//sView.addView(text);
		border.addView(inner);
		linear.addView(border);
		root = (ViewGroup)linear;
		setContentView(root);
	}
	
	public void setTitle(String str)
	{
		title.setText(str);
	}
	
	public void setQuestion(String str)
	{
		question.setText(str);
	}
	
	public String getEdit()
	{
		return edit.getText().toString();
	}
	
	public void show(){
		preShow();
		int[] location = new int[2];
		anchor.getLocationOnScreen(location);
		
		//root.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		window.showAtLocation(this.anchor, Gravity.CENTER, 0, 0);
	}
	
	private int getPixel(int dip)
	{
		return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dip, anchor.getResources().getDisplayMetrics());
	}
	
	private Bitmap getBitmap(String filename) {
		Bitmap bitmap = null;
		try {
			InputStream is = anchor.getResources().getAssets().open(filename); 
			bitmap = BitmapFactory.decodeStream(is);
		} catch (Exception e) {} 
		
		return bitmap;
	}
}