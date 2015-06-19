package br.ufc.virtual.smd.oqcomer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class NovoProdutoFragment extends Fragment {

    private ImageView ivSatisfactionTypeImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_novo_produto, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        prepareSpinnerPrivacy(R.id.sp_satisfaction_types);
        ivSatisfactionTypeImage = (ImageView) view.findViewById(R.id.iv_satisfaction_type_image);
        super.onViewCreated(view, savedInstanceState);
    }

    protected void prepareSpinnerPrivacy(int spPrivacy) {
        Spinner sp_new_physical_activity_privacy = (Spinner) getView().findViewById(spPrivacy);
        sp_new_physical_activity_privacy.setAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.satisfaction_types, R.layout.simple_spinner_item));
        sp_new_physical_activity_privacy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.the_best_icon);
                        break;
                    case 1:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.deliciuos_icon);
                        break;
                    case 2:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.great_icon);
                        break;
                    case 3:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.very_good_icon);
                        break;
                    case 4:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.like_icon);
                        break;
                    case 5:
                        ivSatisfactionTypeImage.setBackgroundResource(R.drawable.good_icon);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
