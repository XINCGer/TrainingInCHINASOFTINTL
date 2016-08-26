package com.example.demo_08_18;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Activity01 extends Activity {
	private ListView mListView;
	// 需要适配的数据
	private String[] names = { "京东商城", "QQ", "QQ斗地主", "新浪微博", "天猫", "UC浏览器",
			"微信" };
	// 图片集合
	private int[] icons = { R.drawable.jd, R.drawable.qq, R.drawable.qq_dizhu,
			R.drawable.sina, R.drawable.tmall, R.drawable.uc, R.drawable.weixin };

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
			View view = View.inflate(Activity01.this, R.layout.list_item,
					null);
			// 找到list_view.xml中创建的TextView
			TextView mTextView = (TextView) view.findViewById(R.id.tv_list);
			mTextView.setText(names[position]);
			ImageView imageView = (ImageView) view.findViewById(R.id.image);
			imageView.setBackgroundResource(icons[position]);
			return view;
		}


	}
}
