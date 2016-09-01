package com.example.administrator.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.demo1.tool.PracelableBean;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {


    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


         text1=(TextView)findViewById(R.id.text1);
        //接收参数
        Bundle bunde = this.getIntent().getExtras();
        String username = bunde.getString("username");
       ArrayList list= bunde.getParcelableArrayList("list");
        System.out.println("**2***"+list);
        //通过序列化获取参数
        HashMap<String,String> map =  (HashMap<String,String>)bunde.getSerializable("serializable");
        System.out.println("******3*********"+map);
        //通过接口获取参数
        PracelableBean xp =  this.getIntent().getParcelableExtra("Parcelable");
        System.out.println("*******4*********"+xp.name+":"+xp.age+":"+xp.mMap);

        text1.setText(username);
    }
}
