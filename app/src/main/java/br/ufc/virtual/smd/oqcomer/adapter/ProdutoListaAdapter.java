package br.ufc.virtual.smd.oqcomer.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufc.virtual.smd.oqcomer.R;
import br.ufc.virtual.smd.oqcomer.utils.DownloadImageTask;

/**
 * Created by leoomoreira on 14/06/2015.
 */
public class ProdutoListaAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final String[] imagePath;
    private Bitmap[] imageContent;

    public ProdutoListaAdapter(Activity context, String[] itemName, String[] imagePath) {
        super(context, R.layout.produto_lista, itemName);
        this.context = context;
        this.itemName = itemName;
        this.imagePath = imagePath;
        this.imageContent = new Bitmap[imagePath.length];
        for (int i = 0; i < imageContent.length; i++) {
            imageContent[i] = null;
        }
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.produto_lista, null, true);

        TextView itemNameComponent = (TextView) rowView.findViewById(R.id.itemName);
        ImageView imageViewComponent = (ImageView) rowView.findViewById(R.id.imagePath);
        TextView extraTextComponent = (TextView) rowView.findViewById(R.id.extraText);

        itemNameComponent.setText(itemName[position]);
        if (imageContent[position] == null) {
            new DownloadImageTask(imageViewComponent, this, position).execute(imagePath[position]);
        } else {
            imageViewComponent.setImageBitmap(imageContent[position]);
        }

        extraTextComponent.setText(itemName[position]);
        return rowView;
    }

    public void setImageContent(Bitmap bitmap, int position) {
        imageContent[position] = bitmap;
    }

}
