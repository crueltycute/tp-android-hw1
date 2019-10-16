package ru.tp.android_hw1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.NumbersList.NumbersListAdapter;
import ru.tp.android_hw1.fragment.NumbersList.NumbersListFragment;
import ru.tp.android_hw1.fragment.OneNumberFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(getLogTag(), "onCreate");

        addNumbersListFragment();
    }

    private void addNumbersListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        NumbersListFragment numbersList = (NumbersListFragment) fragmentManager.findFragmentById(R.id.numbers_list_fragment);

        if (numbersList == null) {
            transaction.replace(R.id.main, NumbersListFragment.newInstance());
        }

        transaction.commit();
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }
}
