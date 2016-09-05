package com.example.administrator.moshouapplication.tool;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/23.
 */
public class StreamTools {
    /**
     * 将输入流转换成字符串
     *
     * @param is 从网络获取的输入流
     * @return
     */
    public static String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
                System.out.println("==========================3===================" + buffer);
            }
            System.out.println("*******1*****" + new String(buffer).trim());
            baos.flush();
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(buffer).trim();
        } catch (Exception e) {
            Log.e("读取错误", e.toString());
            return null;
        }
    }

    /**
     * 通过HttpUrlConnection发送GET请求
     *
     * @param username
     * @param password
     * @return
     */
    public static String loginByGet(String username, String password) {
        System.out.println("================1===============");
        String path = "http://10.0.2.2:8080/Demo1/LoginServlet?username=" + username + "&password=" + password;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);//4，设置连接超时时间。
            conn.setRequestMethod("GET");//设置请求方式。
            int code = conn.getResponseCode();//获取响应码
            //请求码200，表明请求成功，获取返回内容的输入流

            if (code == 200) {
                InputStream is = conn.getInputStream(); // 字节流转换成字符串
                return StreamTools.streamToString(is);
            } else {
                return "网络访问失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "网络访问失败";
        }
    }

    //通用的请求和获取参数的方法
    public static  String getMess(String actionname,String data){
        String path = "http://10.0.2.2:8080/sshDemo/"+actionname;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");//不设置这个属性也能拿到数据，并且注意POST要全大写
            conn.setUseCaches(false);//post方式不能使用缓存，安全问题
            conn.setDoOutput(true); // 设置可输出流,不设置dooutput属性，无法在内容上送数据
            conn.setInstanceFollowRedirects(true);//如果不设置这个属性，那么上送的参数是对象时，有可能抛出异常

            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            //POST方式，其实就是浏览器把数据写给服务器
            if(!data.equals("")) {
                OutputStream os = conn.getOutputStream(); // 获取输出流
                os.write(data.getBytes()); // 将数据写给服务器
                os.flush();
                os.close();
            }
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                return StreamTools.streamToString(is);
            } else {
                return "网络访问失败";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "网络访问失败";

        }
    }



    public static String loginByPost(String username, String password) {
        String path = "http://10.0.2.2:8080/sshDemo/LoginAction";
                try {
                    URL url = new URL(path);
                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("POST");//不设置这个属性也能拿到数据，并且注意POST要全大写
                    conn.setUseCaches(false);//post方式不能使用缓存，安全问题
                    conn.setDoOutput(true); // 设置可输出流,不设置dooutput属性，无法在内容上送数据
                    conn.setInstanceFollowRedirects(true);//如果不设置这个属性，那么上送的参数是对象时，有可能抛出异常

                    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                    String data = "username="+username+"&password="+password;


                //   conn.setRequestProperty("Content-Length", data.length());
                //POST方式，其实就是浏览器把数据写给服务器

                    OutputStream os = conn.getOutputStream(); // 获取输出流
                    os.write(data.getBytes()); // 将数据写给服务器
                    os.flush();
                    os.close();
                 int code = conn.getResponseCode();
                if (code == 200) {
               InputStream is = conn.getInputStream();
                       return StreamTools.streamToString(is);
                     } else {
                    return "网络访问失败";
                  }
                }
         catch (Exception e) {
             e.printStackTrace();
             return "网络访问失败";

                             }
            }


    }
