package com.example.demo_08_12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity02 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		Intent intent = getIntent();
		String data = intent.getStringExtra("data");
		TextView tv = (TextView) findViewById(R.id.tv_show);
		tv.setText(data);
	}
}
