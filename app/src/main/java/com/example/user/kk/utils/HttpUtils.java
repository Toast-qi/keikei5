package com.example.user.kk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 2016/8/13.
 */
public class HttpUtils {

    public static String httpGet(String path){

        String ruselt = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            URL url = new URL(path);
            HttpURLConnection connectin = (HttpURLConnection) url.openConnection();
            connectin.setRequestMethod("GET");
            inputStream = connectin.getInputStream();
             outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
           ruselt = new String(outputStream.toByteArray()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if (inputStream !=null){

                    inputStream.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    return  ruselt;
    }


public static  String  httpPost(String path, String str){


    String ruselt = null;
    InputStream inputStream = null;
    ByteArrayOutputStream outputStream = null;

    try {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        //设一些连接属性，不设置也可以请求成功
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(8000);
        connection.connect();

        //传递post参数给服务器
        OutputStream outputStream1 = connection.getOutputStream();
        outputStream1.write(str.getBytes());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream1);
        bufferedOutputStream.flush();




        //使用输入流把服务器的数据读入到内存中
        inputStream = connection.getInputStream();
        //准备把输入流读到输出流中
        outputStream = new ByteArrayOutputStream();
        // 字节数据，每次从输入流中读取的长度
        byte[] bytes = new byte[1024];
        //判断当次读取出来的字节有多少
        int len = 0;
        //把输入流中的内容全部读入到输出流中
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        ruselt= new String(outputStream.toByteArray());

    } catch (Exception e) {
        e.printStackTrace();
    } finally {

        try {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    return ruselt;
}

//请求图片：
    public static Bitmap HttpGetBitmap(String path){
        Bitmap bitmap= null;
        InputStream inputStream = null;
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //确定当前请求的类型， 必须大写  GET  POST
            connection.setRequestMethod("GET");
            //使用输入流把服务器的数据读入到内存中
            inputStream = connection.getInputStream();

            bitmap= BitmapFactory.decodeStream(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return bitmap;




    }





}
