package universitblaisepascal.virlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Rachid on 16/03/2016.
 */
public class Image extends AsyncTask<Void, Void, Bitmap> {

    String lien;

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    protected Bitmap doInBackground(Void ... params) {

        URL urlWelcome = null;
        Bitmap bitmap = null;

        try {
            urlWelcome = new URL(lien);
            HttpURLConnection connection = (HttpURLConnection) urlWelcome.openConnection();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
