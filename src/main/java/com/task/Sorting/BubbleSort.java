package com.task.Sorting;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BubbleSort {

    private static ArrayList<Float> sort_int = new ArrayList<>();


    public BubbleSort(String str1) {
        String str = str1 + "  ";
        NumInput(str);
    }

    private void NumInput(String str) {
        Pattern pattern = Pattern.compile("[\\d+.]");
        Matcher matcher;
        String num = "";
        for (int i = 0; i < str.length() - 1; ++i) {
            matcher = pattern.matcher(str.substring(i, i + 1));
            if (matcher.find())
                num += str.substring(i, i + 1);
            else {
                if (!num.equals("")) {
                    sort_int.add(Float.parseFloat(num));
                    num = "";
                }
            }
        }
    }

    public ArrayList<Float> sortAsc() {
        for (int j = sort_int.size() - 1; j != 0; --j)
            for (int i = 0; i < j; ++i)
                if (sort_int.get(i + 1) < sort_int.get(i)) {
                    Float a = sort_int.get(i);
                    sort_int.set(i, sort_int.get(i + 1));
                    sort_int.set(i + 1, a);
                }
        return sort_int;
    }
    public ArrayList<Float> sortDes() {
        for (int j = sort_int.size() - 1; j != 0; --j)
            for (int i = 0; i < j; ++i)
                if (sort_int.get(i + 1) > sort_int.get(i)) {
                    Float a = sort_int.get(i);
                    sort_int.set(i, sort_int.get(i + 1));
                    sort_int.set(i + 1, a);
                }
        return sort_int;
    }

    public ArrayList sort(boolean on) {
        if (on)
            return sortDes();
        else
            return sortAsc();
    }
}
