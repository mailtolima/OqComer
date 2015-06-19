package br.ufc.virtual.smd.oqcomer.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufc.virtual.smd.oqcomer.R;

public class ProductListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final int[] banners;
    private final String[] foodNames;
    private final String[] restaurantLocals;
    private final String[] localDistances;
    private final String[] countComments;
    private final int[] satisfactionFlags;

    public ProductListAdapter(Activity context, int[] banners, String[] foodNames, String[] restaurantLocals, String[] localDistances, String[] countComments, int[] satisfactionFlags) {
        super(context, R.layout.produto_lista, foodNames);
        this.context = context;
        this.banners = banners;
        this.foodNames = foodNames;
        this.restaurantLocals = restaurantLocals;
        this.localDistances = localDistances;
        this.countComments = countComments;
        this.satisfactionFlags = satisfactionFlags;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.produto_lista, null, true);

        ImageView ivProductBanner = (ImageView) rowView.findViewById(R.id.iv_product_banner);
        TextView tvFoodName = (TextView) rowView.findViewById(R.id.tv_food_name);
        TextView tvRestaurantLocal = (TextView) rowView.findViewById(R.id.tv_restaurant_local);
        TextView tvLocalDistance = (TextView) rowView.findViewById(R.id.tv_local_distance);
        TextView tvCountComment = (TextView) rowView.findViewById(R.id.tv_count_comment);
        ImageView ivSatisfactionFlag = (ImageView) rowView.findViewById(R.id.iv_satisfaction_flag);

        ivProductBanner.setBackgroundResource(banners[position]);
        tvFoodName.setText(foodNames[position]);
        tvRestaurantLocal.setText(restaurantLocals[position]);
        tvLocalDistance.setText(localDistances[position]);
        tvCountComment.setText(countComments[position]);
        ivSatisfactionFlag.setBackgroundResource(satisfactionFlags[position]);
        return rowView;
    }

}
