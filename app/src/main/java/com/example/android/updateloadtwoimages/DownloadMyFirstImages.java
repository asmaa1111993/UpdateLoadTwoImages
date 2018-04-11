package com.example.android.updateloadtwoimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by BASMALA on 06/04/2018.
 */

public class DownloadMyFirstImages extends AsyncTask<String, Void, Bitmap[]> {


    @Override
    protected Bitmap[] doInBackground(String... strings) {
        // create an array to store the loaded images
        Bitmap[] myImageArray = new Bitmap[2] ;

        try {
            //establish connection to load the first image
            URL url = new URL(strings[0]);
            HttpsURLConnection connect1 = (HttpsURLConnection) url.openConnection();
            connect1.setReadTimeout(10000);
            connect1.setConnectTimeout(15000);
            connect1.setRequestMethod("GET");
            connect1.connect();
            InputStream firstImageStream = connect1.getInputStream();
            myImageArray[0] = BitmapFactory.decodeStream(firstImageStream);
            firstImageStream.close();
            connect1.disconnect();
            // //establish connection to load the second image
            URL url2 = new URL(strings[1]);
            HttpsURLConnection connect2 = (HttpsURLConnection) url2.openConnection();
            connect2.setReadTimeout(10000);
            connect2.setConnectTimeout(15000);
            connect2.setRequestMethod("GET");
            connect2.connect();
            InputStream secondImageStream = connect2.getInputStream();
            myImageArray[1] = BitmapFactory.decodeStream(secondImageStream);
            secondImageStream.close();
            connect2.disconnect();

            //return myImageArray " the array that stores the loaded images "
            return myImageArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        super.onPostExecute(bitmaps);
        MainActivity.firstPhoto.setImageBitmap(bitmaps[0]);
        MainActivity.secondPhoto.setImageBitmap(bitmaps[1]);
    }
}
