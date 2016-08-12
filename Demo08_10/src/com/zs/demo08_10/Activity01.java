package com.zs.demo08_10;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class Activity01 extends Activity {
	private ProgressBar bar;
	private Button button;
	private Handler handler;
	Runnable runnable;
	int step=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		bar=(ProgressBar) findViewById(R.id.pb_1);
		button=(Button) findViewById(R.id.start);
		handler=new Handler();
		runnable = new Runnable() {
			
			@Override
			public void run() {
				bar.setVisibility(View.VISIBLE);
				step+=bar.getProgress()+1;
				bar.setProgress(step);
				if(step<100){
					handler.postDelayed(runnable, 300);
				}
				
			}
		};
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handler.post(runnable);
				
			}
		});
		

	}
}
