package ru.tp.android_hw1.fragment.NumbersList;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.tp.android_hw1.R;


public class NumbersListFragment extends Fragment {
    private static final int DEFAULT_LAST_NUM = 3;

    private static final String KEY_LAST_NUMBER = "last_number";
    private static int lastNumber = 100;

    public static NumbersListFragment newInstance(int lastNumberParam) {
        NumbersListFragment fragment = new NumbersListFragment();
        Bundle bundle = new Bundle();
//        lastNumber = lastNumberParam;
//        bundle.putInt(KEY_LAST_NUMBER, lastNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            int lastNumber = savedInstanceState.getInt(KEY_LAST_NUMBER, DEFAULT_LAST_NUM);
            Log.d(getLogTag(), "onCreate: " + lastNumber);
        } else {
            Log.d(getLogTag(), "onCreate");
        }

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(getLogTag(), "onCreateView");

        return inflater.inflate(R.layout.fragment_numbers_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView numbersView = view.findViewById(R.id.numbers_list_view);

        int columnsNum = 3;
        int currentOrientation = getResources().getConfiguration().orientation;

        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsNum = 4;
        }

        GridLayoutManager numbersLayoutManager = new GridLayoutManager(getContext(), columnsNum, currentOrientation, false);
        numbersView.setLayoutManager(numbersLayoutManager);

        NumbersListAdapter numbersAdapter = new NumbersListAdapter();
        numbersView.setAdapter(numbersAdapter);

        for (int i = 1; i <= lastNumber; i++) {
            numbersAdapter.addNumber(i);
        }

        Log.d(getLogTag(), "onViewCreated");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getLogTag(), "onSaveInstanceState");
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }
}
