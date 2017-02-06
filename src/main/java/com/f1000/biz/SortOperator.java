package com.f1000.biz;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.f1000.services.filter.Filter;
import com.f1000.services.rank.Rank;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public class SortOperator<T> {

    private List<T> items = new ArrayList<>();

    private SortOperator(List<T> journalList){
        items = new ArrayList<T>(journalList);
    }

    public static <T> SortOperator<T> init(List<T> journalList) {
        return new SortOperator<T>(journalList);
    }

    public SortOperator<T> sort(Comparator<T> sortComparator) {
        Collections.sort(items, sortComparator);
        return this;
    }


    public SortOperator<T> filter(Filter<T> filter) {
        List<T> result = new ArrayList<T>();
        for (T o : (Collection<T>) items) {
            if (filter.doFilter(o)) {
                result.add(o);
            }
        }

        this.items = result;
        return this;
    }

    public SortOperator<T> rank(Rank<T> rank) {
        rank.doRanking(items);
        return this;
    }

    public T get(int i) {
        return this.items.get(i);
    }

    public int size(){
        return this.items.size();
    }


}
