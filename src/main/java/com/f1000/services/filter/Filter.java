package com.f1000.services.filter;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public interface Filter<T> {

    boolean doFilter(T journal);
}
