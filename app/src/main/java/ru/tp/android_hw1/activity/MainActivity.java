package ru.tp.android_hw1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.NumbersListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(getLogTag(), "onCreate");

        initNumbersListFragment();
    }

    private void initNumbersListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        NumbersListFragment numbersList = (NumbersListFragment) fragmentManager.findFragmentById(R.id.fragment_numbers_list);

        if (numbersList == null) {
            transaction.replace(R.id.main, new NumbersListFragment());
        }

        transaction.commit();
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }
}
