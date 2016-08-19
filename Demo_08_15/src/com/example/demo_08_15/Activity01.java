package com.example.demo_08_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import vo.Person;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Activity01 extends Activity {
	List<Person> personInfos = null;
	Person person;
	ArrayList<HashMap<String, Object>> list;
	TextView summary;
	int averageAge=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity_01);

		GridView gridview = (GridView) findViewById(R.id.gridview_2);
		summary=(TextView) findViewById(R.id.summmary);
		getPersonInfos();
		list = new ArrayList<HashMap<String, Object>>();
		Iterator it= personInfos.iterator();
		while(it.hasNext()){
			Person p= (Person) it.next();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("person", p);
			list.add(map);
			averageAge+=Integer.parseInt(p.getAge());
		}
		averageAge=averageAge/personInfos.size();
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view =View.inflate(Activity01.this, R.layout.gridview_item, null);
				TextView textview=(TextView) view.findViewById(R.id.textview);
				ImageView imgView=(ImageView) view.findViewById(R.id.image);
				Person p=(Person) list.get(position).get("person");
				textview.setText(p.getName());
				if("��".equals(p.getGender())){
					imgView.setImageResource(R.drawable.chongzhi);
				}else{
					imgView.setImageResource(R.drawable.twitter);
				}
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return list.get(position);
			}
			
			@Override
			public int getCount() {
				return list.size();
			}
		};
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new MyListener());
		summary.setText("��"+personInfos.size()+"��,ƽ��������:"+averageAge+"��");
	}
	
	class MyListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Person p=(Person) list.get(position).get("person");
			Intent intent= new Intent(Activity01.this, Activity02.class);
			intent.putExtra("name", p.getName());
			intent.putExtra("gender", p.getGender());
			intent.putExtra("age", p.getAge());
			startActivity(intent);
		}
		
	}
	
	public void getPersonInfos() {
		// ����һ��pull������
		XmlPullParser parser = getResources().getXml(R.xml.persons);
		// ��ʼ������������һ����������xml����
		try {
			int type = parser.getEventType(); // ��ȡ��ǰ�¼�����
			while (type != XmlPullParser.END_DOCUMENT) {
				switch (type) {
				// һ���ڵ�Ŀ�ʼ��ǩ
				case XmlPullParser.START_TAG:
					if ("persons".equals(parser.getName())) {
						personInfos = new ArrayList<Person>();
					}
					if ("person".equals(parser.getName())) {
						person = new Person();
						person.setAge(parser.getAttributeValue(0));
						person.setGender(parser.getAttributeValue(1));
						try {
							person.setName(parser.nextText().toString()); // nextText�õ��ýڵ������
						} catch (IOException e) {
							e.printStackTrace();
						} 
						personInfos.add(person);
					}

					break;
				// һ���ڵ�Ľ�����ǩ
				case XmlPullParser.END_TAG:
					Log.d("bbb", "bbb");
					break;
				default:
					break;
				}
				try {
					type = parser.next();	// ֻҪ���������ĵ���ĩβ���ͽ�����һ����Ŀ
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
	
}
