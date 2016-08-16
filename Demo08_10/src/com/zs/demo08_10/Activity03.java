package com.zs.demo08_10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.SumPathEffect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class Activity03 extends Activity {
	RatingBar rBar;
	TextView tv;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity03);
		rBar=(RatingBar) findViewById(R.id.rb_1);
		tv=(TextView) findViewById(R.id.tv_3);
		submit=(Button) findViewById(R.id.submit);
		submit.setEnabled(false);
		OnRatingBarChangeListener listener= new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				tv.setText("Ç×£¬Äú´òÁË"+rBar.getRating()+"·Ö");
				if(rating<3)submit.setEnabled(false);
				else submit.setEnabled(true);
				
			}
		};
		rBar.setOnRatingBarChangeListener(listener);
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Activity03.this, Activity04.class);
				intent.putExtra("data", String.valueOf(rBar.getRating()));
				startActivity(intent);
			}
		});
	}
}
