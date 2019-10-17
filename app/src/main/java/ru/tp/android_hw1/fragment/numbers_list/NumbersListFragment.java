package ru.tp.android_hw1.fragment.numbers_list;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.tp.android_hw1.R;


public class NumbersListFragment extends Fragment {
    private static int mLastNumber;
    private static String KEY_LAST_NUMBER = "key_last_number";

    public static NumbersListFragment newInstance(int numberCount) {
        NumbersListFragment fragment = new NumbersListFragment();

        Bundle bundle = new Bundle();

        mLastNumber = numberCount;
        bundle.putInt(KEY_LAST_NUMBER, mLastNumber);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments != null) {
            mLastNumber = arguments.getInt(KEY_LAST_NUMBER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            mLastNumber = savedInstanceState.getInt(KEY_LAST_NUMBER);
        }

        RecyclerView numbersView = view.findViewById(R.id.numbers_list_view);

        int columnsNum = 3;
        int currentOrientation = getResources().getConfiguration().orientation;

        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsNum = 4;
        }

        GridLayoutManager numbersLayoutManager = new GridLayoutManager(getContext(), columnsNum, currentOrientation, false);
        numbersView.setLayoutManager(numbersLayoutManager);

        final NumbersListAdapter numbersAdapter = new NumbersListAdapter(getFragmentManager());
        numbersView.setAdapter(numbersAdapter);

        for (int i = 1; i <= mLastNumber; i++) {
            numbersAdapter.addNumber();
        }

        Button newNumberButton = view.findViewById(R.id.new_number);
        newNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLastNumber++;
                numbersAdapter.addNumber();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_LAST_NUMBER, mLastNumber);
    }
}