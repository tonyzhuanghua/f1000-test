package com.f1000.biz.comparators;

import com.f1000.entity.Journal;

import java.util.Comparator;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public class CompareByScore implements Comparator<Journal> {

    @Override
    public int compare(Journal j1, Journal j2) {
        int compareResult = 0;
        if (j1.getScore() < j2.getScore()) {
            compareResult = 1;
        } else if (j1.getScore() == j2.getScore()) {
            compareResult = 0;
        } else if (j1.getScore() > j2.getScore()) {
            compareResult = -1;
        }

        return compareResult;
    }
}
