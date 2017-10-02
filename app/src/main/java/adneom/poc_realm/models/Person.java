package adneom.poc_realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by gtshilombowanticale on 14-08-17.
 */

public class Person extends RealmObject{

    private String lastName;
    private String firstName;
    private Integer userId;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String toString(){
        return userId+" "+lastName+" "+firstName;
    }
}
