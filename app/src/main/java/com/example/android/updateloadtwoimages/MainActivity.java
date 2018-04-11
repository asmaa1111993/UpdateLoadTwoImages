package com.example.android.updateloadtwoimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static ImageView firstPhoto,secondPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstPhoto = findViewById(R.id.firstImageView);
        secondPhoto = findViewById(R.id.secondImageView);
    }

    public void downLoadTwoImages(View view) {
        //parsing the images url to the start connection
        new DownloadMyFirstImages().execute("https://tse4.mm.bing.net/th?id=OIP.rTG1KGPK4nMusQSvZZm2SwHaFS&pid=15.1&P=0&w=226&h=162"
                , "https://spotlight.it-notes.ru/wp-content/uploads/2017/01/ab996ee436ce1851aef7d87bec74e65f.jpg");
    }
}
