package adneom.poc_realm;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {

    private Context context;

    ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }


    @Provides
    Realm provideRealm(){
        Realm.init(context);
        return Realm.getDefaultInstance();
    }

}
