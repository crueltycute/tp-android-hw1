package ru.tp.android_hw1.fragment.NumbersList;

import android.graphics.Color;

public class Number {
    private int mNumber;
    private int mColor;

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
        return number % 2 == 1 ? Color.RED : Color.BLUE;  // 0 - четное, красный; 1 - нечетное, синий
    }
}
