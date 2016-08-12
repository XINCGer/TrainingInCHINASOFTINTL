package com.zs.demo08_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private CheckBox cb1;
	private CheckBox cb2;
	private CheckBox cb3;
	private CheckBox cb4;
	private TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cb1=(CheckBox) findViewById(R.id.java);
		cb2=(CheckBox) findViewById(R.id.python);
		cb3=(CheckBox) findViewById(R.id.ruby);
		cb4=(CheckBox) findViewById(R.id.erlang);
		tv1=(TextView) findViewById(R.id.tv_1);
		CheckBoxHandler listener=new CheckBoxHandler();
		cb1.setOnCheckedChangeListener(listener);
		cb2.setOnCheckedChangeListener(listener);
		cb3.setOnCheckedChangeListener(listener);
		cb4.setOnCheckedChangeListener(listener);
	}
	private class CheckBoxHandler implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			String tmp="";
			if(cb1.isChecked()==true){
				tmp+=cb1.getText();
			}
			if(cb2.isChecked()==true){
				tmp+=cb2.getText();
			}
			if(cb3.isChecked()==true){
				tmp+=cb3.getText();
			}
			if(cb4.isChecked()==true){
				tmp+=cb4.getText();
			}
			tv1.setText("ƒ„œ≤ª∂µƒ±‡≥Ã”Ô—‘”–£∫"+tmp);
			
		}
		
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
		else if(id==R.id.item1){
			Intent intent= new Intent(MainActivity.this, Activity01.class);
			startActivity(intent);
		}
		else if(id==R.id.item2){
			Intent intent= new Intent(MainActivity.this, Activity02.class);
			startActivity(intent);
		}
		else if(id==R.id.item3){
			Intent intent= new Intent(MainActivity.this, Activity03.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
