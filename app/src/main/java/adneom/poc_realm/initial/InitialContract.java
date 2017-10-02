package adneom.poc_realm.initial;


import android.content.Context;

import adneom.poc_realm.BasePresenter;
import adneom.poc_realm.BaseView;

public interface InitialContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void saveModel(Context context);
    }
}
