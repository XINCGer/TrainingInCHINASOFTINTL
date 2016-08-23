package com.example.demo_08_16;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import vo.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btnPull;
	private Button btnSax;
	private TextView tv1;
	List<Person> list = null;
	Person person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnPull = (Button) findViewById(R.id.button_1);
		btnSax = (Button) findViewById(R.id.button_2);
		tv1 = (TextView) findViewById(R.id.tv_1);
		// /////////////////////////////////////
		btnPull.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getPersonInfos();
				Iterator it= list.iterator();
				String str="";
				while(it.hasNext()){
					Person p= (Person) it.next();
					str+="Age:"+p.getAge()+"Gender:"+p.getGender()+"Name:"+p.getName()+"\n";
				}
				tv1.setText(str);
			}
		});
	}

	public void getPersonInfos() {
		// 创建一个pull解析器
//		XmlPullParser parser = Xml.newPullParser();
		XmlPullParser parser = getResources().getXml(R.xml.persons);
		// 初始化解析器，第一个参数代表xml数据
		try {
//			parser.setInput(MainActivity.class.getClassLoader()
//					.getResourceAsStream("person.xml"), "utf-8");
			int type = parser.getEventType(); // 获取当前事件类型
			while (type != XmlPullParser.END_DOCUMENT) {
				switch (type) {
				// 一个节点的开始标签
				case XmlPullParser.START_TAG:
					if ("persons".equals(parser.getName())) {
						list = new ArrayList<Person>();
					}
					if ("person".equals(parser.getName())) {
						person = new Person();
						person.setAge(parser.getAttributeValue(0));
						person.setGender(parser.getAttributeValue(1));
						try {
							person.setName(parser.nextText().toString()); // nextText得到该节点的内容
						} catch (IOException e) {
							e.printStackTrace();
						} 
						list.add(person);
					}

					break;
				// 一个节点的结束标签
				case XmlPullParser.END_TAG:
					Log.d("bbb", "bbb");
//					if ("person".equals(parser.getName())) {
//						list.add(person);
//						person = null;
//					}
					break;
				default:
					break;
				}
				try {
					type = parser.next();	// 只要不解析到文档的末尾，就解析下一个条目
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
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
		if (id == R.id.gallery_show) {
			Intent intent = new Intent(MainActivity.this,
					Activity_Gallery.class);
			startActivity(intent);
		}
		if (id == R.id.gallery_show1) {
			Intent intent = new Intent(MainActivity.this,
					Activity01.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
