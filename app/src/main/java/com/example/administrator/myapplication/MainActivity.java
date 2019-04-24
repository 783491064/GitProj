package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.image.SeniorCropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private SeniorCropImageView iv;
    private String savePath;
    private String filePath;
    private int [] arr=new int[]{1, 23, 1, 1, 1, 3, 23, 5, 6, 7, 9, 9, 8, 5};
    private ene ene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        iv = (SeniorCropImageView)findViewById(R.id.iv);
        iv.setCropRatio(5f / 4f);
        filePath = saveBitmp();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImagePath(filePath);
            }
        });
        Button bt= (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DesActivity.class);
                startActivity(intent);
            }
        });
    }


    private String saveBitmp() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ivbg);

        savePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/123.jpg";
        File file=new File(savePath);
        if(!file.exists()){
            try {
                file.createNewFile();
                FileOutputStream fos=new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return savePath;
    }

    private List<String> list=new ArrayList<>();
    public void stream(){
        for(int i=0;i<10;i++){
            list.add(i+"");
        }

    }

    public interface ene{
        void noty(String s);
    }
  public void setListener(ene ene){
        this.ene=ene;

  }
    
}
