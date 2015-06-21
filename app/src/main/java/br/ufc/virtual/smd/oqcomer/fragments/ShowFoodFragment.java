package br.ufc.virtual.smd.oqcomer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufc.virtual.smd.oqcomer.R;
import br.ufc.virtual.smd.oqcomer.model.DataBase;

public class ShowFoodFragment extends Fragment {
    private static final String POSITION_PARAM = "position";

    private int position;

    public static ShowFoodFragment newInstance(int position) {
        ShowFoodFragment fragment = new ShowFoodFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(POSITION_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_food, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        view.findViewById(R.id.iv_food_banner).setBackgroundResource(DataBase.banners[position]);
        view.findViewById(R.id.iv_satisfaction_flag).setBackgroundResource(DataBase.satisfactionFlags[position]);
        ((TextView) view.findViewById(R.id.tv_food_name)).setText(DataBase.foodNames[position]);
        ((TextView) view.findViewById(R.id.tv_food_description)).setText(DataBase.foodDescriptions[position]);
        ((TextView) view.findViewById(R.id.tv_restaurant_name)).setText(DataBase.restaurantLocal[position]);
        ((TextView) view.findViewById(R.id.tv_restaurant_description)).setText(DataBase.restaurantDescriptions[position]);
        ((TextView) view.findViewById(R.id.tv_food_opinion)).setText(DataBase.foodOpinions[position]);
        view.findViewById(R.id.iv_satisfaction_type_image).setBackgroundResource(DataBase.foodSatisfactionImage[position]);
        super.onViewCreated(view, savedInstanceState);
    }
}
