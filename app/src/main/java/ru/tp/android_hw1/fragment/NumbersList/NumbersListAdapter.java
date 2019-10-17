package ru.tp.android_hw1.fragment.NumbersList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.OneNumberFragment;


public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {
    private List<Number> mNumbers;
    private static int mNumbersCount;
    private FragmentManager mFragmentManager;

    NumbersListAdapter(FragmentManager fragmentManager) {
        mNumbers = new ArrayList<Number>();
        mNumbersCount = 0;
        mFragmentManager = fragmentManager;
    }

    public int getNumbersCount() {
        return mNumbersCount;
    }

    public void addNumber() {
        mNumbers.add(new Number(++mNumbersCount));
        notifyItemInserted(mNumbersCount);
    }

    @NonNull
    @Override
    public NumbersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View numberView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.number, parent, false);
        return new NumbersListViewHolder(numberView);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersListViewHolder holder, int position) {
        final Number num = mNumbers.get(position);

        holder.Number.setText(String.valueOf(num.getNumber()));
        holder.Number.setTextColor(num.getColor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                transaction.replace(R.id.numbers_list_fragment, OneNumberFragment.newInstance(num.getNumber()));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }
}

class NumbersListViewHolder extends RecyclerView.ViewHolder {
    public final TextView Number;

    public NumbersListViewHolder(@NonNull View itemView) {
        super(itemView);
        Number = itemView.findViewById(R.id.number);
    }
}