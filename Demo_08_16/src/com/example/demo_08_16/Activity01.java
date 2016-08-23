package com.example.demo_08_16;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Activity01 extends Activity {
	private ArrayList<Integer> list =new ArrayList<Integer>();
	private Gallery gallery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		/////////////////////////////////
		gallery=(Gallery) findViewById(R.id.gallery_1);
		list.add(R.drawable.a1);
		list.add(R.drawable.a2);
		list.add(R.drawable.a3);
		list.add(R.drawable.a4);
		list.add(R.drawable.a5);
		list.add(R.drawable.a6);
		try {
//			gallery.setAdapter(new ImageAdapter(Activity_Gallery.this));
			gallery.setAdapter(adapter);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		gallery.setSelection(3);
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setTitle("��ǰ������"+String.valueOf(position+1)+"��");
				ImageView img=(ImageView) findViewById(R.id.image_1);
				img.setBackgroundResource(list.get(position%list.size()));
				
			}
		});
	}
	BaseAdapter adapter = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(Activity01.this, R.layout.item, null);
			view.setBackgroundResource(list.get(position%list.size()));	//ΪimageView����ͼ����Դ
			view.setLayoutParams(new Gallery.LayoutParams(150,150)); 	//����ͼ�񲼾ֺ���ʾ��С
			view.setPadding(15, 0, 15, 0);
			return view;
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Object getItem(int position) {
			return position;
		}
		
		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}
	};
	
//	class ImageAdapter extends BaseAdapter{
//
//		private Context context;	//������
//		private Integer [] images={R.drawable.a1,R.drawable.a2,R.drawable.a4,R.drawable.a3,R.drawable.a5,R.drawable.a6};	//����ͼ��Դ
//		public ImageAdapter(Context c)throws IllegalArgumentException,IllegalAccessException{
//			context=c;
//		}
//		@Override
//		public int getCount() {
//			return images.length;	//��ȡͼ��ĸ���
//		}
//
//		@Override
//		public Object getItem(int position) {
//			return position; 	//��ȡͼ�������
//		}
//
//		@Override
//		public long getItemId(int position) {
//			return position;
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			ImageView view = new ImageView(context);
//			view.setImageResource(images[position]);	//ΪimageView����ͼ����Դ
//			view.setScaleType(ImageView.ScaleType.FIT_XY);	//���ñ�������
//			view.setLayoutParams(new Gallery.LayoutParams(200,200)); 	//����ͼ�񲼾ֺ���ʾ��С
//			view.setPadding(15, 0, 15, 0);
//			return view;
//			
//		}
//		
//	}
}
