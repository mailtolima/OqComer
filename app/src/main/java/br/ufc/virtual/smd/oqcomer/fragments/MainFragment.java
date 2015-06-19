package br.ufc.virtual.smd.oqcomer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.ufc.virtual.smd.oqcomer.R;
import br.ufc.virtual.smd.oqcomer.adapter.ProductListAdapter;

public class MainFragment extends Fragment {

    private ListView produtoLista;
    private int[] banners = {
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3
    };
    private String[] foodNames = {
            "Pastel de requeijão com carne seca",
            "Nachos mechicanos a moda da casa",
            "Escondidinho de camarão"
    };
    private String[] restaurantLocal = {
            "Dom Pastel",
            "Floresta Gourmet",
            "Florence l'escale"
    };
    private String[] localDistances = {
            "0,6 Km",
            "1,1 Km",
            "0,8 Km"
    };
    private String[] countComments = {
            "15",
            "41",
            "18"
    };
    private int[] satisfactionFlags = {
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ProductListAdapter adapter = new ProductListAdapter(getActivity(), banners, foodNames, restaurantLocal, localDistances, countComments, satisfactionFlags);
        produtoLista = (ListView) view.findViewById(R.id.produtoLista);
        produtoLista.setAdapter(adapter);

        produtoLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = foodNames[+position];
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
