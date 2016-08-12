package com.zs.demo08_10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class Activity03 extends Activity {
	RatingBar rBar;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity03);
		rBar=(RatingBar) findViewById(R.id.rb_1);
		tv=(TextView) findViewById(R.id.tv_3);
		OnRatingBarChangeListener listener= new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				tv.setText("Ç×£¬Äú´òÁË"+rBar.getRating()+"·Ö");
				
			}
		};
		rBar.setOnRatingBarChangeListener(listener);
	}
}
