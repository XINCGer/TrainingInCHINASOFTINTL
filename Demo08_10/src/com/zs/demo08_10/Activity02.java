package com.zs.demo08_10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Activity02 extends Activity {
	SeekBar sBar;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		sBar=(SeekBar) findViewById(R.id.sBar_1);
		tv=(TextView) findViewById(R.id.tv_2);
		sBar.setMax(100);
		sBar.setProgress(0);
		OnSeekBarChangeListener listener=new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tv.setText("当前进度"+sBar.getProgress());
				
			}
		};
		sBar.setOnSeekBarChangeListener(listener);
	}
}
