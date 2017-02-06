package com.f1000.services.filter;

import com.f1000.entity.Journal;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public class FilterImpl implements Filter<Journal> {
    @Override
    public boolean doFilter(Journal journal) {
        return !journal.isReview();
    }
}
