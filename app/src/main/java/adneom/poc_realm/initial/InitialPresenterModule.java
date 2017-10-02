package adneom.poc_realm.initial;


import dagger.Module;
import dagger.Provides;

@Module
public class InitialPresenterModule {

    private InitialContract.View mView;

    public InitialPresenterModule(InitialContract.View view) {
        mView = view;
    }

    @Provides
    InitialContract.View provideInitialView() {
        return mView;
    }
}
