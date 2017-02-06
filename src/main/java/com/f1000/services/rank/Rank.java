package com.f1000.services.rank;

import java.util.List;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public interface Rank <T> {

    public void doRanking(List<T> journals);

}

