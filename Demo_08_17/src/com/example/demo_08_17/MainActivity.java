package com.example.demo_08_17;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textview=(TextView) findViewById(R.id.textView);
//		try {
//			InputStream is=getResources().getAssets().open("test.txt");
//			byte []buf=new byte[1024];
//			while(true){
//				int temp=is.read(buf);
//				if(temp==-1)break;
//				textview.append(new String(buf));
//			}
//			is.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			InputStream in=getAssets().open("test.txt");
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte []buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))>0){
				baos.write(buf,0,len);
			}
			String msg=new String(baos.toByteArray());
			textview.setText(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
