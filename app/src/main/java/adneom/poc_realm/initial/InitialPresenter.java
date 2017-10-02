package adneom.poc_realm.initial;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import adneom.poc_realm.MyApplication;
import adneom.poc_realm.models.Person;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by gtshilombowanticale on 14-08-17.
 */

public class InitialPresenter implements InitialContract.Presenter{

    private InitialContract.View initialView;
    private Context context;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    InitialPresenter(InitialContract.View initialView){
        this.initialView = initialView;
        this.initialView.setPresenetr(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void saveModel(Context context) {
        this.context = context;
        Realm realm = ((MyApplication)this.context).getAppComponent().getRealm();
        deleteAlls(realm);
        //addPersonSimply(realm);
        addPersonWihtoutRefresh(realm);

        persons(realm);
    }

    private void deleteAlls(Realm realm){
        // Build the query looking at all users:
        RealmQuery<Person> query = realm.where(Person.class);
        // Execute the query:
        RealmResults<Person> result1 = query.findAll();
        result1.deleteAllFromRealm();
    }

    private void addPersonSimply(Realm realm){
        realm.beginTransaction();
        Person person1 = realm.createObject(Person.class);
        person1.setUserId(1);
        person1.setLastName("test 1");
        person1.setFirstName("test 1");

        Person person2 = realm.createObject(Person.class);
        person2.setUserId(2);
        person2.setLastName("test 2");
        person2.setFirstName("test 2");

        Person person3 = realm.createObject(Person.class);
        person3.setUserId(3);
        person3.setLastName("test 3");
        person3.setFirstName("test 3");

        realm.commitTransaction();
    }

    private void addPersonWihtoutRefresh(Realm realm){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Person person1 = new Person();
                person1.setUserId(1);
                person1.setLastName("one");
                person1.setFirstName("one :)");
                //realm.copyToRealm(person1);

                Person person2 = new Person();
                person2.setUserId(2);
                person2.setLastName("two ");
                person2.setFirstName("two :(");
                //realm.copyToRealm(person2);

                Person person3 = new Person();
                person3.setUserId(3);
                person3.setLastName("three :)");
                person3.setFirstName("three");
                //realm.copyToRealm(person3);

                Person person4 = new Person();
                person4.setUserId(4);
                person4.setLastName("four");
                person4.setFirstName("four");
                //realm.copyToRealm(person4);

                Person person5 = new Person();
                person5.setUserId(5);
                person5.setLastName("five");
                person5.setFirstName("five");
                // This will update an existing object with the same primary key
                // or create a new object
                //realm.copyToRealm(person5);
            }
        });
    }

    private void persons(Realm realm){
        // Build the query looking at all users:
        RealmQuery<Person> query = realm.where(Person.class);
        // Execute the query:
        RealmResults<Person> result1 = query.findAll();
        for(Person p : result1){
            Log.i("Test",p.toString());
        }
    }
}
