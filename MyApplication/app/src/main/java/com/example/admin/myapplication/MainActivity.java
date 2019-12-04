package com.example.admin.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private CameraSurfaceView surfaceView;
    private RelativeLayout surfaceviewlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        surfaceviewlayout=findViewById(R.id.surfaceviewlayout);
        surfaceView=new CameraSurfaceView(MainActivity.this);
        surfaceviewlayout.addView(surfaceView);
    }
//相机权限
    void requestPermission(){
        final int REQUEST_CODE = 1;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        }
    }
}
