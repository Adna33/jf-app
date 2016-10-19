package eestec.jobfairapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 * Created by Adna on 19/10/2016.
 */
public class LoadImageTask  extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;

    public LoadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        //if(!urldisplay.contains("image"))
        //    urldisplay = "http://cdn3.wpbeginner.com/wp-content/uploads/2015/08/error.jpg";
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }

}
