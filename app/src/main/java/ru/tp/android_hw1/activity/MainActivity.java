package ru.tp.android_hw1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.numbers_list.NumbersListFragment;

public class MainActivity extends AppCompatActivity {
    private int mNumbersCount;
    private String KEY_NUMBERS_COUNT = "key_numbers_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addNumbersListFragment();
        }
    }

    private void addNumbersListFragment() {
        setNumbersCount(getResources().getInteger(R.integer.numbers_count));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        NumbersListFragment numbersList = (NumbersListFragment) fragmentManager.findFragmentById(R.id.numbers_list_fragment);

        if (numbersList == null) {
            transaction.replace(R.id.main, NumbersListFragment.newInstance(mNumbersCount));
        }

        transaction.commit();
    }

    private void setNumbersCount(int numbersCount) {
        mNumbersCount = numbersCount;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBERS_COUNT, mNumbersCount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            setNumbersCount(savedInstanceState.getInt(KEY_NUMBERS_COUNT));
        } else {
            setNumbersCount(getResources().getInteger(R.integer.numbers_count));
        }
    }
}
