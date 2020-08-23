package dagger2.example.com.twowaydatabinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger2.example.com.twowaydatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        //binding.setPerson(new Person());
        PersonViewModel personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        binding.setPerson(personViewModel);
        personViewModel.getFirstName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String firstname) {
                System.out.println(firstname);
            }
        });
    }
}
