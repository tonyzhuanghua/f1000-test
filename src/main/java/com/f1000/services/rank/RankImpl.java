package com.f1000.services.rank;

import com.f1000.entity.Journal;

import java.util.List;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public class RankImpl implements Rank<Journal> {
    @Override
    public void doRanking(List<Journal> journals) {

        for(Journal journal : journals){

            int index = journals.lastIndexOf(journal);

            if(index != 0 && journals.get(index-1).getScore() == journal.getScore()){
                journal.setRank(journals.get(index-1).getRank());
            } else {
                journal.setRank(++index);
            }
        }

    }
}
