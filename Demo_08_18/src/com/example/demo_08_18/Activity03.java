package com.example.demo_08_18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity03 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivity03);
		ImageView image=(ImageView) findViewById(R.id.image03);
		TextView textView1=(TextView) findViewById(R.id.textViewName03);
		TextView textView2=(TextView) findViewById(R.id.textViewTime03);
		TextView textView3=(TextView) findViewById(R.id.textViewIntroduce03);
		Intent intent=getIntent();
		Person p=(Person) intent.getSerializableExtra("data");
		image.setBackgroundResource(p.getTouxiang());
		textView1.setText(p.getName());
		textView2.setText(p.getTime());
		textView3.setText(p.getIntroduce());
	}
}
