package adneom.poc_realm.initial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import adneom.poc_realm.R;

/**
 * Created by gtshilombowanticale on 14-08-17.
 */

public class InitialFragment extends Fragment implements InitialContract.View, View.OnClickListener {

    private InitialContract.Presenter presenter;

    private Button btnSave;


    public InitialFragment(){}

    public static InitialFragment newInstance() {
        return new InitialFragment();
    }

    @Override
    public void setPresenetr(@NonNull InitialContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_initial,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSave = (Button)getActivity().findViewById(R.id.save_model);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_model:
                presenter.saveModel(getActivity().getApplication());
                break;
        }
    }
}
