package ru.tp.android_hw1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.tp.android_hw1.R;

public class NumbersListFragment extends Fragment {

    public static NumbersListFragment newInstance(int instance) {
        NumbersListFragment fragment = new NumbersListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
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

        Log.d(getLogTag(), "onViewCreated");
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }
}
