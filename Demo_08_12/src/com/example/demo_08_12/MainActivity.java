package com.example.demo_08_12;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private TextView tv5;
	private TextView tv6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(TextView) findViewById(R.id.tv_1);
		tv2=(TextView) findViewById(R.id.tv_2);
		tv3=(TextView) findViewById(R.id.tv_3);
		tv4=(TextView) findViewById(R.id.tv_4);
		tv5=(TextView) findViewById(R.id.tv_5);
		tv6=(TextView) findViewById(R.id.tv_6);
		
		///////////////////////////////////////
		tv1.setText(Html.fromHtml("<font color='red' size=18>我是18号红色字体</font>"));
		tv2.setText(Html.fromHtml("<a href='www.baidu.com'>百度</a>"));
		tv2.setMovementMethod(LinkMovementMethod.getInstance());
		ImageGetter imagegetter=new ImageGetter() {
			
			@Override
			public Drawable getDrawable(String source) {
				Drawable draw=null;
				int id=Integer.parseInt(source);
				draw=getResources().getDrawable(id);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				return draw;
			}
		};
		
		
		ImageGetter getter1= new ImageGetter() {
			
			@Override
			public Drawable getDrawable(String source) {
				Drawable draw=null;
				draw=Drawable.createFromPath(source);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				return draw;
			}
		};
		tv3.setText(Html.fromHtml("笑<img src=\"/sdcard/smiley_4.png\"/>",getter1,null));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if(id==R.id.activity01){
			Intent intent = new Intent(MainActivity.this, Activity01.class);
			startActivity(intent);
		}
		if(id==R.id.activity03){
			Intent intent = new Intent(MainActivity.this, Activity03.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
