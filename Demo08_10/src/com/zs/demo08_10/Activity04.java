package com.zs.demo08_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity04 extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity04);
		tv=(TextView) findViewById(R.id.tv_show);
		Intent intent=getIntent();
		String data=intent.getStringExtra("data");
		tv.setText("ÄúµÄÆÀ·ÖÊÇ£º"+data+"¿ÅÐÇ£¡");
	}
}
