package com.example.demo_08_12;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity03 extends Activity {
	private TextView tv;
	private Spinner sp;
	private Spinner sp1;
	private Spinner sp2;
	private static final String[] language = { "Java", "Python", "Ruby",
			"Scala", "Erlang", "Node.js" };
	private static final String[] face = { "Ð¦", "Æ²×ì", "É«",
		"·¢´ô", "¿á"};
	private static final int [] icons={R.drawable.smiley_0,R.drawable.smiley_1,R.drawable.smiley_2,R.drawable.smiley_3,R.drawable.smiley_4};
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity03);
		tv = (TextView) findViewById(R.id.tv_language);
		sp = (Spinner) findViewById(R.id.spinner);
		adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_spinner_item, language);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		OnItemSelectedListener listener = new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				tv.setText("ÄúµÄ±à³ÌÓïÑÔÊÇ£º" + language[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				tv.setText("ÇëÑ¡ÔñÄúµÄ±à³ÌÓïÑÔ£º");
			}
		};
		sp.setOnItemSelectedListener(listener);
		
		sp1=(Spinner) findViewById(R.id.spinner1);
		MyBaseAdapter baseAdapter=new MyBaseAdapter();
		sp1.setAdapter(baseAdapter);
		sp2=(Spinner) findViewById(R.id.spinner2);
		
		final ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1= new HashMap<String, Object>();
		map1.put("msg", "Î¢Ð¦");
		map1.put("img", R.drawable.smiley_0);
		list.add(map1);
		
		HashMap<String, Object> map2= new HashMap<String, Object>();
		map2.put("msg", "Æ²×ì");
		map2.put("img", R.drawable.smiley_1);
		list.add(map2);
		
		HashMap<String, Object> map3= new HashMap<String, Object>();
		map3.put("msg", "É«");
		map3.put("img", R.drawable.smiley_2);
		list.add(map3);
		
		HashMap<String, Object> map4= new HashMap<String, Object>();
		map4.put("msg", "·¢´ô");
		map4.put("img", R.drawable.smiley_3);
		list.add(map4);
		
		HashMap<String, Object> map5= new HashMap<String, Object>();
		map5.put("msg", "¿á");
		map5.put("img", R.drawable.smiley_4);
		list.add(map5);
		
		String [] from={"msg","img"};
		int [] to={R.id.textview,R.id.image};
		SimpleAdapter adapter1=new SimpleAdapter(this, list, R.layout.sub_activity, from, to);
		sp2.setAdapter(adapter1);
		
		sp2.setOnItemSelectedListener(new  OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				TextView tvA=(TextView) findViewById(R.id.tvA);
				ImageView imageA=(ImageView) findViewById(R.id.imageA);
				tvA.setText(list.get(position).get("msg").toString());
				imageA.setBackgroundResource(Integer.parseInt(list.get(position).get("img").toString()));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	class MyBaseAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return face.length;
		}

		@Override
		public Object getItem(int position) {
			return face[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view =View.inflate(Activity03.this, R.layout.sub_activity, null);
			TextView textview=(TextView) view.findViewById(R.id.textview);
			ImageView imageview=(ImageView) view.findViewById(R.id.image);
			textview.setText(face[position]);
			imageview.setBackgroundResource(icons[position]);
			return view;
		}
		
	}
	
}
