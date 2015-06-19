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
            R.drawable.banner_3,
            R.drawable.bolo_chocolate,
            R.drawable.brigadeiro,
            R.drawable.brownie,
            R.drawable.cachorro_quente,
            R.drawable.cajuina,
            R.drawable.camarao,
            R.drawable.coxinha,
            R.drawable.empada,
            R.drawable.escondidinho_carnedosol,
            R.drawable.hamburguer,
            R.drawable.kalzonekalzone,
            R.drawable.misto_quente,
            R.drawable.ohmydog,
            R.drawable.palha_italiana,
            R.drawable.pao_de_queijo,
            R.drawable.pastel_de_queijo,
            R.drawable.picanha,
            R.drawable.pizzahut_peperoni,
            R.drawable.po_de_guarana,
            R.drawable.rock_burguer,
            R.drawable.salada_fruta,
            R.drawable.self_service_fisica,
            R.drawable.sushi_oxente,
            R.drawable.torta_frango,
            R.drawable.vitamina_acai

    };
    private String[] foodNames = {
            "Pastel de requeijão com carne seca",
            "Nachos mechicanos a moda da casa",
            "Escondidinho de camarão",
            "Bolo de chocolate",
            "Brigadeiro",
            "Brownie de chocolate",
            "Cachorro quente",
            "Cajuina de verdade",
            "Camarão alho e óleo",
            "Coxinha",
            "Empada",
            "Escondidinho de carne do sol",
            "Hamburguer",
            "Kalzone de calabresa",
            "Misto quente",
            "Oh my dog peperoni",
            "Palha italiana",
            "Pão de queijo",
            "Pastel de queijo",
            "Picanha com batatas",
            "Pizza de peperoni",
            "Pó de guaraná",
            "Rock burger",
            "Salada de frutas",
            "Self service",
            "Sushis variados",
            "Torta de frango",
            "Vitamina de Açai"
    };
    private String[] restaurantLocal = {
            "Dom Pastel",
            "Floresta Gourmet",
            "Florence l'escale",
            "Cantina da Química",
            "Cantina da Tia Jô",
            "Cantina da SEARA de Ciências",
            "Cantina da Tia Jô",
            "Cantina da Química",
            "Cantina da Tia Jô",
            "Cantina da Geologia",
            "Cantina da Eng. de Pesca",
            "Cantina da Física",
            "Cantina da Geologia",
            "Kalzone",
            "Cantina da SEARA de Ciências",
            "Oh my dog",
            "Cantina da Tia Jô",
            "Cantina da Química",
            "Cantina da Tia Jô",
            "Restaurante Alex",
            "Pizza Hut",
            "Ponto da Vitamina",
            "Rock And Burgers",
            "Cantina da Tia Jô",
            "Cantina da Física",
            "Oxente oriente",
            "Cantina da Química",
            "Cantina da Eng. de Pesca"
    };
    private String[] localDistances = {
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km",
            "1,1 Km",
            "0,8 Km",
            "0,6 Km"
    };
    private String[] countComments = {
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15",
            "41",
            "18",
            "15"
    };
    private int[] satisfactionFlags = {
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
            R.drawable.the_best_flag,
            R.drawable.great_flag,
            R.drawable.very_good_flag,
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
