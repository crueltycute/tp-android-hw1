package ru.tp.android_hw1.adapter;

import ru.tp.android_hw1.R;


public class Number {
    private final int mNumber;
    private final int mColor;

    public Number(int number) {
        mNumber = number;
        mColor = countNumberColor(number);
    }

    public int getNumber() {
        return mNumber;
    }

    public int getColor() {
        return mColor;
    }

    private int countNumberColor(int number) {
        return number % 2 == 1 ? R.color.colorEvenNumber : R.color.colorOddNumber;
    }
}
