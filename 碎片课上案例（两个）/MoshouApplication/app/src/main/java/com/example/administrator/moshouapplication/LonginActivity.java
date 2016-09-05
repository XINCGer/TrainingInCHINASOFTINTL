package com.example.administrator.moshouapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.moshouapplication.tool.StreamTools;

public class LonginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btn_submit;
    TextView mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longin);

        if (android.os.Build.VERSION.SDK_INT > 9) {     StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();     StrictMode.setThreadPolicy(policy); }



        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        mess=(TextView)findViewById(R.id.mess);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                //String ss= StreamTools.loginByGet(username.getText().toString(),password.getText().toString());
                String ss = StreamTools.loginByPost(username1, password1);
                System.out.println("========" + ss + "==========");

                if (ss.equals("success")) {


                    Intent intent = new Intent();
                    intent.setClass(LonginActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();//装参数
                    bundle.putString("username", username1);
                    intent.putExtras(bundle);//参数放入Intent中
                    startActivity(intent);//跳转到另一个页面
                } else {

                    mess.setText("登陆失败");
                }


//                if(ss.equals("success")){
//                  Intent intentSimple = new Intent();
//                  intentSimple.setClass(MainActivity.this, Main2Activity.class);
//                  Bundle bundleSimple = new Bundle();//装参数
//                  //传递简单参数
//                  bundleSimple.putString("username", username.getText().toString());
//
//
//                  //传递复杂参数
//                  Map<String,Object> map=new HashMap<String,Object>();
//                  map.put("username", "tom");
//                  Map<String,Object> map1=new HashMap<String,Object>();
//                  map1.put("username", "mike");
//                  ArrayList list=new ArrayList();
//                    list.add(map);
//                    list.add(map1);
//
//                  bundleSimple.putParcelableArrayList("list", list);
                //通过java序列化数据传递参数
//                  HashMap<String,String> map2 = new HashMap<String,String>();
//                  map2.put("key1", "apple");
//                  map2.put("key2", "banana");
//
//                  bundleSimple.putSerializable("serializable", map2);
//                  //通过接口实现数据传递
//                  PracelableBean xp = new PracelableBean();
//                  xp.age = 18;
//                  xp.name = "范冰冰";
//                  xp.mMap = new HashMap<String,String>();
//                  xp.mMap.put("接口参数", "哈哈");
//                  intentSimple.putExtra("Parcelable", xp);
//
//
//                  intentSimple.putExtras(bundleSimple);//参数放入Intent中
//                  startActivity(intentSimple);//跳转到另一个页面
//              }else {
//                  mess.setText("登陆失败");
//              }
            }
        });



    }
}
