package com.zs.layouttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String[] myContent = { "www.baidu.com", "www.163.com",
			"www.taobao.com", "www.vip.com", "unity3d", "python" };
	private AutoCompleteTextView autoView = null;
	private RadioButton rbtn1;
	private RadioButton rbtn2;
	private RadioButton rbtn3;
	private RadioButton rbtn4;
	private RadioGroup rg;
	private TextView tv_2;
	private MultiAutoCompleteTextView multiAutoView=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		setContentView(R.layout.acitivity08_09_01);
		setContentView(R.layout.activity_08_10_02);
		Button button1=(Button) findViewById(R.id.btn1);
		Button button2=(Button) findViewById(R.id.btn2);
		Button button3=(Button) findViewById(R.id.btn3);
		button1.setOnClickListener(new ButtonHandler());
		button2.setOnClickListener(new ButtonHandler());
		button3.setOnClickListener(new ButtonHandler());
//		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//				android.R.layout.simple_dropdown_item_1line, myContent);
//		autoView = (AutoCompleteTextView) findViewById(R.id.autoView);
//		autoView.setAdapter(adapter);
//		autoView.setThreshold(3);
//		Button button1 = (Button) findViewById(R.id.button1);
//		rbtn1 = (RadioButton) findViewById(R.id.java);
//		rbtn2 = (RadioButton) findViewById(R.id.python);
//		rbtn3 = (RadioButton) findViewById(R.id.ruby);
//		rbtn4 = (RadioButton) findViewById(R.id.erlang);
//		rg = (RadioGroup) findViewById(R.id.radiogroup1);
//		tv_2 = (TextView) findViewById(R.id.tv_2);
//		multiAutoView=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoView);
//		multiAutoView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//		multiAutoView.setAdapter(adapter);
//		multiAutoView.setThreshold(3);
//		button1.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				TextView view1 = (TextView) findViewById(R.id.tv_1);
//				String text=view1.getText().toString();
//				view1.append(Html
//						.fromHtml("<font color='red'>student.</font>"));
//			}
//		});
//
//		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//
//			@Override
//			public void onCheckedChanged(RadioGroup group, int checkedId) {
//				if (R.id.java == checkedId) {
//					tv_2.setText("您选择的编程语言是：" + rbtn1.getText());
//				} else if (R.id.python == checkedId) {
//					tv_2.setText("您选择的编程语言是：" + rbtn2.getText());
//				} else if (R.id.ruby == checkedId) {
//					tv_2.setText("您选择的编程语言是：" + rbtn3.getText());
//				} else if (R.id.erlang == checkedId) {
//					tv_2.setText("您选择的编程语言是：" + rbtn4.getText());
//				}
//			}
//		});
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
		else if(id==R.id.item_1){
			Intent intent=new Intent(this,Activity01.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class ButtonHandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn1:
				Log.d("MainActivity", "1");
				break;
			case R.id.btn2:
				Log.d("MainActivity", "2");
				break;
			case R.id.btn3:
				Log.d("MainActivity", "3");
				break;
			default:
				break;
			}
		}
		
	}
}
