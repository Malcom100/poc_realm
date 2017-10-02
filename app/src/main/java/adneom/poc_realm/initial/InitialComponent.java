package adneom.poc_realm.initial;


import adneom.poc_realm.util.FragmentScoped;
import dagger.Component;

@FragmentScoped
@Component(modules = InitialPresenterModule.class)
public interface InitialComponent {

    void inject(InitialActivity activity);
}
