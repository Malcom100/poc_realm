package adneom.poc_realm.initial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import adneom.poc_realm.R;


public class InitialActivity extends AppCompatActivity {

    @Inject InitialPresenter initialPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);


        InitialFragment frg = (InitialFragment)getSupportFragmentManager().findFragmentById(R.id.container);
        if(frg == null){
            //create the fragment
            frg = InitialFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,frg,"Fragment").commit();
        }
        //Create the presenter
        DaggerInitialComponent.builder().initialPresenterModule(new InitialPresenterModule(frg)).build().inject(this);
    }
}
