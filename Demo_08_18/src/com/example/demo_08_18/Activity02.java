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
	// ��Ҫ���������
	private String[] names = { "����ʶŮ��", "����", "��Ӱζ��", "ʱ��Ů��", "AK����", "����С���",
			"����" };
	// ͼƬ����
	private int[] icons = { R.drawable.shejiao, R.drawable.shezhi,
			R.drawable.shock, R.drawable.snow, R.drawable.shejiao,
			R.drawable.tv, R.drawable.twitter, R.drawable.xiugai, };
	private String []times={"07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08","07-29 19:08"};
	private String []introduces={"malloc��free��C++/C���Եı�׼�⺯����new/delete��C++��������� ���Ƕ����������붯̬�ڴ���ͷ��ڴ档"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity01);
		// ��ʼ��ListView�ؼ�
		mListView = (ListView) findViewById(R.id.lv);
		// ����һ��Adapterʵ��
		MyBaseAdapter mAdapter = new MyBaseAdapter();
		// ����Adapter
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

	// ����һ����̳�BaseAdapter
	class MyBaseAdapter extends BaseAdapter {

		@Override
		// �õ�Item������
		public int getCount() {
			// ����ListView Item��Ŀ������
			return names.length;
		}

		@Override
		// ����ListView����Ķ���
		public Object getItem(int position) {
			// ����ListView Item��Ŀ����Ķ���
			return names[position];
		}

		@Override
		// �õ�Item��ID
		public long getItemId(int position) {
			// ����ListView Item��id
			return position;
		}

		@Override
		// �õ�Item��View��ͼ
		public View getView(int position, View convertView, ViewGroup parent) {
			// ��list_item.xml�ļ��ҳ�����ת����View����
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
