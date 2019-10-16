package ru.tp.android_hw1.fragment.NumbersList;

import android.graphics.Color;

public class Number {
    public Number(int number) {
        Number = number;
        mColor = countNumberColor(number);
    }

    private int countNumberColor(int number) {
        return number % 2 == 1 ? Color.RED : Color.BLUE;  // 0 - четное, красный; 1 - нечетное, синий
    }

    public int Number;  // TODO(): make private
    public int mColor;  // TODO(): rename
}
