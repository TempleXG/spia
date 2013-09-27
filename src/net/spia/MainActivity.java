package net.spia;

import net.spia.view.pop.Pop;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RectButton btn;
	private ImageButton imgbtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//btn = (RectButton)findViewById(R.id.button1);
        //btn.setBackgroundColor(Color.CYAN);
		
		
		
		imgbtn = (ImageButton)findViewById(R.id.button1);
		imgbtn.setNormalImage(R.drawable.btn_yes);
		
		imgbtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				Pop pop = new Pop(v, R.layout.popup);

				pop.show();

				Button innerBtn = (Button)pop.getView().findViewById(R.id.innerBtn);
				innerBtn.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						Toast mToast = Toast.makeText(MainActivity.this, "So Cool", Toast.LENGTH_SHORT);
						mToast.show();
				}});
				
				
		}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
