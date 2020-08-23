package dagger2.example.com.twowaydatabinding;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.view.View;

/**
 * Created by muhammadchehab on 1/5/18.
 */

public class Person implements Observable {

    private PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    private String firstName;
    private String lastName;
    private String age;

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        propertyChangeRegistry.notifyChange(this, BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        propertyChangeRegistry.notifyChange(this, BR.lastName);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        propertyChangeRegistry.notifyChange(this, BR.age);
    }

    public void onButtonClick(View view){
        setFirstName("first name");
        setLastName("last name");
        setAge("23");
    }
}