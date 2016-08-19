package com.example.demo_08_15;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridview=(GridView) findViewById(R.id.gridview_1);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for(int i=0;i<10;i++){
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("img", R.drawable.pic0);
			map.put("msg", "¿¨ÅÆ"+String.valueOf(i));
			list.add(map);
		}
		
		SimpleAdapter adapter= new SimpleAdapter(this, list, R.layout.gridview_item, new String []{"img","msg"}, new int []{R.id.image,R.id.textview});
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new MyListener());
	}
	
	class MyListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			HashMap<String, Object> map=(HashMap<String, Object>)parent.getItemAtPosition(position);
			setTitle((String)map.get("msg"));
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
		if(id==R.id.item_1){
			Intent intent=new Intent(MainActivity.this, Activity01.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
