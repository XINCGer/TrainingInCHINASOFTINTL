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
	// ��Ҫ���������
	private String[] names = { "�����̳�", "QQ", "QQ������", "����΢��", "��è", "UC�����",
			"΢��" };
	// ͼƬ����
	private int[] icons = { R.drawable.jd, R.drawable.qq, R.drawable.qq_dizhu,
			R.drawable.sina, R.drawable.tmall, R.drawable.uc, R.drawable.weixin };

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
			View view = View.inflate(Activity01.this, R.layout.list_item,
					null);
			// �ҵ�list_view.xml�д�����TextView
			TextView mTextView = (TextView) view.findViewById(R.id.tv_list);
			mTextView.setText(names[position]);
			ImageView imageView = (ImageView) view.findViewById(R.id.image);
			imageView.setBackgroundResource(icons[position]);
			return view;
		}


	}
}
