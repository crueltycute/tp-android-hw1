package ru.tp.android_hw1.adapter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.tp.android_hw1.R;
import ru.tp.android_hw1.fragment.OneNumberFragment;


public class NumbersAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {
    private final List<Number> mNumbers;
    private final Context mContext;

    public NumbersAdapter(Context context) {
        mNumbers = new ArrayList<Number>();
        mContext = context;
    }

    public void addNumber() {
        int numbersCount = mNumbers.size() + 1;
        mNumbers.add(new Number(numbersCount));
        notifyItemInserted(numbersCount);
    }

    @NonNull
    @Override
    public NumbersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View numberView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_number, parent, false);
        return new NumbersListViewHolder(numberView);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersListViewHolder holder, int position) {
        final Number num = mNumbers.get(position);

        holder.numberView.setText(String.valueOf(num.getNumber()));
        holder.numberView.setTextColor(mContext.getResources().getColor(num.getColor()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = ((Activity) mContext).getFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.main_container, OneNumberFragment.newInstance(num.getNumber()));
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
    final TextView numberView;

    NumbersListViewHolder(@NonNull View itemView) {
        super(itemView);
        numberView = itemView.findViewById(R.id.number);
    }
}