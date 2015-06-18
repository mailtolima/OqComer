package br.ufc.virtual.smd.oqcomer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

import br.ufc.virtual.smd.oqcomer.adapter.ProdutoListaAdapter;

/**
 * Created by leoomoreira on 14/06/2015.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageViewComponent;
    private Bitmap imageContent;
    private ProdutoListaAdapter adapter;
    private int position;

    public DownloadImageTask(ImageView imageViewComponent, ProdutoListaAdapter adapter, int position) {
        this.imageViewComponent = imageViewComponent;
        this.adapter = adapter;
        this.position = position;
        this.imageContent = null;
    }

    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = urls[0];
        Bitmap imageContent = null;
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            imageContent = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageContent;
    }

    protected void onPostExecute(Bitmap imageContent) {
        imageViewComponent.setImageBitmap(imageContent);
        adapter.setImageContent(imageContent, position);
    }

}