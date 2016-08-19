package com.example.demo_08_15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity02 extends Activity {
	private ImageView image;
	private TextView tvName;
	private TextView tvAge;
	private TextView tvGender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		image = (ImageView) findViewById(R.id.personView);
		tvName = (TextView) findViewById(R.id.tv_name);
		tvAge = (TextView) findViewById(R.id.tv_age);
		tvGender = (TextView) findViewById(R.id.tv_gender);
		// //////////////////////////////////////////////
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		String age = intent.getStringExtra("age");
		String gender = intent.getStringExtra("gender");

		if ("��".equals(gender)) {
			image.setImageResource(R.drawable.chongzhi);
		} else {
			image.setImageResource(R.drawable.twitter);
		}
		tvName.setText("������\t"+name);
		tvAge.setText("���䣺\t"+age);
		tvGender.setText("�Ա�\t"+gender);
	}
}
