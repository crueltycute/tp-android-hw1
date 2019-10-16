package ru.tp.android_hw1.fragment.NumbersList;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tp.android_hw1.R;


class Number {
    Number(int number) {
        Number = number;
        mColor = countNumberColor(number);
    }

    private int countNumberColor(int number) {
        return number % 2 == 1 ? Color.RED : Color.BLUE;  // 0 - четное, красный; 1 - нечетное, синий
    }

    int Number;
    int mColor;
}

public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {
    private List<Number> Numbers;

    public void addNumber(int number) {
        Numbers.add(new Number(number));
    }

    NumbersListAdapter() {
        Numbers = new ArrayList<Number>();

//        for (int i = 0; i < 100; i++) {
//            Numbers.add(new Number(i));
//        }
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

        //  TODO(): setOnClickListener
    }
}