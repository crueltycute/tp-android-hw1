package ru.tp.android_hw1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.numbers_list.NumbersListFragment;

public class MainActivity extends AppCompatActivity {
    private int mNumbersCount = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addNumbersListFragment();
        }
    }

    private void addNumbersListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        NumbersListFragment numbersList = (NumbersListFragment) fragmentManager.findFragmentById(R.id.numbers_list_fragment);

        if (numbersList == null) {
            transaction.replace(R.id.main, NumbersListFragment.newInstance(mNumbersCount));
        }

        transaction.commit();
    }
}
