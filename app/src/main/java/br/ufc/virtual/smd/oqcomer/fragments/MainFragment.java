package br.ufc.virtual.smd.oqcomer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.ufc.virtual.smd.oqcomer.R;
import br.ufc.virtual.smd.oqcomer.adapter.ProductListAdapter;
import br.ufc.virtual.smd.oqcomer.model.DataBase;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ProductListAdapter adapter = new ProductListAdapter(
                getActivity(),
                DataBase.banners,
                DataBase.foodNames,
                DataBase.restaurantLocal,
                DataBase.localDistances,
                DataBase.countComments,
                DataBase.satisfactionFlags
        );
        ListView productList = (ListView) view.findViewById(R.id.product_list);
        productList.setAdapter(adapter);

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowFoodFragment showFoodFragment = ShowFoodFragment.newInstance(+position);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, showFoodFragment).addToBackStack(showFoodFragment.getClass().getName());
                fragmentTransaction.commit();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
