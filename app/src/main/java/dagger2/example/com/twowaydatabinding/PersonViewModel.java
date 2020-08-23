package dagger2.example.com.twowaydatabinding;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

public class PersonViewModel extends ViewModel {

    public MutableLiveData<String> firstName = new MutableLiveData<>();;
    public MutableLiveData<String> lastName = new MutableLiveData<>();;
    public MutableLiveData<String> age = new MutableLiveData<>();;

    public MutableLiveData<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    /*public String getLastName() {
        return lastName;
    }*/

    public void setLastNam(String lastName) {
        this.lastName.setValue(lastName);
    }

    /*public String getAge() {
        return age;
    }*/

    public void setAge(String age) {
        this.age.setValue(age);
    }

    public void onButtonClick(View view){
        setFirstName("first name");
        setLastNam("last name");
        setAge("23");
    }

}
