package com.example.demo_08_18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends Activity {
	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			tabHost = (TabHost) this.findViewById(R.id.TabHost1);
			tabHost.setup();
			tabHost.addTab(tabHost
					.newTabSpec("tab1")
					.setContent(R.id.LinearLayout1).setIndicator("选项卡1"));
			tabHost.addTab(tabHost
					.newTabSpec("tab2")
					.setContent(R.id.LinearLayout2).setIndicator("选项卡2"));
			tabHost.addTab(tabHost
					.newTabSpec("tab3")
					.setContent(R.id.LinearLayout3).setIndicator("选项卡3"));
			tabHost.addTab(tabHost
					.newTabSpec("tab4")
					.setContent(R.id.LinearLayout4).setIndicator("选项卡4"));
			tabHost.setCurrentTab(0);
		} catch (Exception e) {
			// TODO: handle exception
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
		if (id == R.id.item_1) {
			Intent intent= new Intent(MainActivity.this, Activity01.class);
			startActivity(intent);
		}
		if (id == R.id.item_2) {
			Intent intent= new Intent(MainActivity.this, Activity02.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
