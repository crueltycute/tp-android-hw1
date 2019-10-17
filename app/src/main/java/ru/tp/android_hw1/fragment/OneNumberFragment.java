package ru.tp.android_hw1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.adapter.Number;

public class OneNumberFragment extends Fragment {
    private static Number mCurrentNumber;

    public static OneNumberFragment newInstance(int currentNumber) {
        mCurrentNumber = new Number(currentNumber);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        assert view != null;

        TextView oneNumberView = view.findViewById(R.id.one_number_fragment);

        oneNumberView.setText(String.valueOf(mCurrentNumber.getNumber()));
        oneNumberView.setTextColor(getResources().getColor(mCurrentNumber.getColor()));
    }
}
