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
import br.ufc.virtual.smd.oqcomer.adapter.ProdutoListaAdapter;

public class MainFragment extends Fragment {

    private ListView produtoLista;
    private String[] itemName ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    private String[] imagemPath ={
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ProdutoListaAdapter adapter=new ProdutoListaAdapter(getActivity(), itemName, imagemPath);
        produtoLista =(ListView) view.findViewById(R.id.produtoLista);
        produtoLista.setAdapter(adapter);

        produtoLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemName[+position];
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
