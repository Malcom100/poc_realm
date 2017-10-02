package adneom.poc_realm;

import android.content.Context;

import adneom.poc_realm.util.FragmentScoped;
import dagger.Component;
import io.realm.Realm;

/**
 * Created by gtshilombowanticale on 14-08-17.
 */

@FragmentScoped
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context getContext();
    Realm getRealm();
}
