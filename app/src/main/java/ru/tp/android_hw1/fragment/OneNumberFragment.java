package ru.tp.android_hw1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.NumbersList.Number;

public class OneNumberFragment extends Fragment {
    private static Number CurrentNumber;

    public static OneNumberFragment newInstance(int currentNumber) {
        CurrentNumber = new Number(currentNumber);
        OneNumberFragment fragment = new OneNumberFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView oneNumberView = view.findViewById(R.id.one_number_fragment);

        oneNumberView.setText(String.valueOf(CurrentNumber.getNumber()));
        oneNumberView.setTextColor(CurrentNumber.getColor());
    }
}
