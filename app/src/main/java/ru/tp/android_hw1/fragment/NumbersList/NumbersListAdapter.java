package ru.tp.android_hw1.fragment.NumbersList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.OneNumberFragment;
import ru.tp.android_hw1.fragment.NumbersList.NumbersListFragment;


public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {
    public List<Number> Numbers;  // TODO(): make private
    public static int NumberCount;  // TODO(): make private

    public static void replaceFragment() {
    }

    public void addNumber(int number) {
        Numbers.add(new Number(++NumberCount));
        notifyItemInserted(NumberCount);
    }

    NumbersListAdapter() {
        Numbers = new ArrayList<Number>();
        NumberCount = 0;
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
        Number num = Numbers.get(position);

        holder.Number.setText(String.valueOf(num.Number));
        holder.Number.setTextColor(num.mColor);

        // TODO(): log
    }

    @Override
    public int getItemCount() {
        return Numbers.size();
    }
}

class NumbersListViewHolder extends RecyclerView.ViewHolder {
    public final TextView Number;

    public NumbersListViewHolder(@NonNull View itemView) {
        super(itemView);
        Number = itemView.findViewById(R.id.number);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getLogTag(), "clicked num");
            }
        });

        //  TODO(): setOnClickListener
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }
}