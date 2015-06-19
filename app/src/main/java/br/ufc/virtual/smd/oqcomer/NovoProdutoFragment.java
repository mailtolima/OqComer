package br.ufc.virtual.smd.oqcomer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class NovoProdutoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novo_produto, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        prepareSpinnerPrivacy(R.id.sp_satisfaction_types);
        super.onViewCreated(view, savedInstanceState);
    }

    protected void prepareSpinnerPrivacy(int spPrivacy) {
        Spinner sp_new_physical_activity_privacy = (Spinner) getView().findViewById(spPrivacy);
        sp_new_physical_activity_privacy.setAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.satisfaction_types, R.layout.simple_spinner_item));
        sp_new_physical_activity_privacy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int arrayPosition = ((Spinner) view.getParent()).getId();
                switch (position) {
                    case 0:

                        break;
                }
            }
        });
    }

}
