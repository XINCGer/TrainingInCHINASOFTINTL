package com.example.demo_08_12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Activity01 extends Activity {
	private CheckBox cb1;
	private CheckBox cb2;
	private CheckBox cb3;
	private CheckBox cb4;
	private Button btn;
	private LinearLayout layout;
	String str="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		
		cb1=(CheckBox) findViewById(R.id.cb1);
		cb2=(CheckBox) findViewById(R.id.cb2);
		cb3=(CheckBox) findViewById(R.id.cb3);
		cb4=(CheckBox) findViewById(R.id.cb4);
		btn=(Button) findViewById(R.id.btn);
		layout=(LinearLayout) findViewById(R.id.layout);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				str="";
				for(int i=0;i<layout.getChildCount();i++){
					CheckBox box=(CheckBox) layout.getChildAt(i);
					if(box.isChecked()){
						str+=","+box.getText();
					}
				}
				str=str.substring(1);
				Intent intent=new Intent(Activity01.this,Activity02.class);
				intent.putExtra("data", str);
				startActivity(intent);
			}
		});
		
//		final ProgressBar bar=(ProgressBar) findViewById(R.id.pb);
//		new Thread(){
//			public void run(){
//				for(int i=0;i<100;i++){
//					bar.setProgress(i);
//					try {
//						sleep(100);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}.start();
//		CheckBoxHandler listener= new CheckBoxHandler();
//		cb1.setOnCheckedChangeListener(listener);
//		cb2.setOnCheckedChangeListener(listener);
//		cb3.setOnCheckedChangeListener(listener);
//		cb4.setOnCheckedChangeListener(listener);
//		btn.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(Activity01.this, str, Toast.LENGTH_SHORT).show();
//			}
//		});
//	}
//	
//	class CheckBoxHandler implements OnCheckedChangeListener{
//
//		@Override
//		public void onCheckedChanged(CompoundButton buttonView,
//				boolean isChecked) {
//			str="";
//			if(cb1.isChecked()){
//				str+=cb1.getText();
//			}
//			if(cb2.isChecked()){
//				str+=","+cb2.getText();
//			}
//			if(cb3.isChecked()){
//				str+=","+cb3.getText();
//			}
//			if(cb4.isChecked()){
//				str+=","+cb4.getText();
//			}
//			if(str.startsWith(",")){
//				str=str.substring(1);
//			}
//		}
//		
	}
	
}
