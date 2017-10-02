package adneom.poc_realm;

import android.app.Application;

/**
 * Created by gtshilombowanticale on 14-08-17.
 */

public class MyApplication extends Application {

    private ApplicationComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
