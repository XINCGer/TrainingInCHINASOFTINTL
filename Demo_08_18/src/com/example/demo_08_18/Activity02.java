package com.example.demo_08_18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Activity02 extends Activity {
	private ListView mListView;
	// 需要适配的数据
	private String[] names = { "闻香识女人", "堆糖", "电影味道", "时尚女王", "AK大神", "马三小伙儿",
			"饥荒" };
	// 图片集合
	private int[] icons = { R.drawable.shejiao, R.drawable.shezhi,
			R.drawable.shock, R.drawable.snow, R.drawable.shejiao,
			R.drawable.tv, R.drawable.twitter, R.drawable.xiugai, };
	private String []times={"07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08"};
	private String []introduces={"malloc与free是C++/C语言的标准库函数，new/delete是C++的运算符。 它们都可用于申请动态内存和释放内存。"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity01);
		// 初始化ListView控件
		mListView = (ListView) findViewById(R.id.lv);
		// 创建一个Adapter实例
		MyBaseAdapter mAdapter = new MyBaseAdapter();
		// 设置Adapter
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Person p=new Person();
				p.setName(names[position]);
				p.setTime(times[position]);
				p.setTouxiang(icons[position]);
				p.setIntroduce(introduces[0]);
				Intent intent= new Intent(Activity02.this,Activity03.class);
				intent.putExtra("data", p);
				startActivity(intent);
			}
			
		});
	}

	// 创建一个类继承BaseAdapter
	class MyBaseAdapter extends BaseAdapter {

		@Override
		// 得到Item的总数
		public int getCount() {
			// 返回ListView Item条目的总数
			return names.length;
		}

		@Override
		// 返回ListView代表的对象
		public Object getItem(int position) {
			// 返回ListView Item条目代表的对象
			return names[position];
		}

		@Override
		// 得到Item的ID
		public long getItemId(int position) {
			// 返回ListView Item的id
			return position;
		}

		@Override
		// 得到Item的View视图
		public View getView(int position, View convertView, ViewGroup parent) {
			// 将list_item.xml文件找出来并转换成View对象
			View view = View.inflate(Activity02.this, R.layout.list_item, null);
			ImageView touXiang=(ImageView) view.findViewById(R.id.touxiang);
			TextView niCheng=(TextView) view.findViewById(R.id.nicheng);
			TextView timeLabel=(TextView) view.findViewById(R.id.time);
			TextView introduce=(TextView) view.findViewById(R.id.jieshao);
			niCheng.setText(names[position]);
			touXiang.setBackgroundResource(icons[position]);
			timeLabel.setText(times[position]);
			introduce.setText(introduces[0]);
			return view;
		}

	}
}
