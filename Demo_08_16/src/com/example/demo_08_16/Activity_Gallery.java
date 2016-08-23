package com.example.demo_08_16;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Gallery extends Activity {
	private ArrayList<Integer> list =new ArrayList<Integer>();
	private Gallery gallery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		/////////////////////////////////
		gallery=(Gallery) findViewById(R.id.gallery);
		list.add(R.drawable.a1);
		list.add(R.drawable.a2);
		list.add(R.drawable.a3);
		try {
//			gallery.setAdapter(new ImageAdapter(Activity_Gallery.this));
			gallery.setAdapter(adapter);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setTitle("当前单击第"+String.valueOf(position+1)+"项");
				
			}
		});
	}
	BaseAdapter adapter = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(Activity_Gallery.this, R.layout.item, null);
			ImageView img= (ImageView) view.findViewById(R.id.imageView);
			img.setImageResource(list.get(position));
			TextView tv=(TextView) view.findViewById(R.id.textView);
			tv.setText("第"+(position+1)+"项");
			return view;
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getCount() {
			return list.size();
		}
	};
	
//	class ImageAdapter extends BaseAdapter{
//
//		private Context context;	//上下文
//		private Integer [] images={R.drawable.a1,R.drawable.a2,R.drawable.a4,R.drawable.a3,R.drawable.a5,R.drawable.a6};	//设置图像源
//		public ImageAdapter(Context c)throws IllegalArgumentException,IllegalAccessException{
//			context=c;
//		}
//		@Override
//		public int getCount() {
//			return images.length;	//获取图像的个数
//		}
//
//		@Override
//		public Object getItem(int position) {
//			return position; 	//获取图像的索引
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
//			view.setImageResource(images[position]);	//为imageView设置图像资源
//			view.setScaleType(ImageView.ScaleType.FIT_XY);	//设置比例类型
//			view.setLayoutParams(new Gallery.LayoutParams(200,200)); 	//设置图像布局和显示大小
//			view.setPadding(15, 0, 15, 0);
//			return view;
//			
//		}
//		
//	}
}
