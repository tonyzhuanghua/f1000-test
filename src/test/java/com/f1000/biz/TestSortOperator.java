package com.f1000.biz;

import com.f1000.biz.comparators.CompareByScore;
import com.f1000.biz.comparators.CompareByScoreAndName;
import com.f1000.entity.Journal;

import java.util.List;

import java.util.ArrayList;

import com.f1000.services.filter.FilterImpl;
import com.f1000.services.rank.RankImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhuanghua on 2017/2/6.
 */
public class TestSortOperator {

    @Test
    public void rank_by_journal_score() {

        List<Journal> journals = new ArrayList<>();

        Journal journalA = new Journal();
        journalA.setJournalName("Journal A");
        journalA.setScore(5.6f);
        journalA.setReview(false);
        journals.add(journalA);

        Journal journalB = new Journal();
        journalB.setJournalName("Journal B");
        journalB.setScore(2.4f);
        journalB.setReview(false);
        journals.add(journalB);


        Journal journalC = new Journal();
        journalC.setJournalName("Journal C");
        journalC.setScore(3.1f);
        journalC.setReview(false);
        journals.add(journalC);

        SortOperator<Journal> sortedJournals = SortOperator.init(journals).sort(new CompareByScore()).rank(new RankImpl());

        assertEquals(journalA, sortedJournals.get(0));
        assertEquals(journalC, sortedJournals.get(1));
        assertEquals(journalB, sortedJournals.get(2));

    }

    @Test
    public void rank_by_journal_score_and_name() {

        List<Journal> journals = new ArrayList<>();


        Journal journalA = new Journal();
        journalA.setJournalName("Journal A");
        journalA.setScore(2.2f);
        journalA.setReview(false);
        journals.add(journalA);

        Journal journalB = new Journal();
        journalB.setJournalName("Journal B");
        journalB.setScore(6.2f);
        journalB.setReview(false);
        journals.add(journalB);

        Journal journalC = new Journal();
        journalC.setJournalName("Journal C");
        journalC.setScore(6.2f);
        journalC.setReview(false);
        journals.add(journalC);

        SortOperator<Journal> sortedJournals = SortOperator.init(journals).sort(new CompareByScoreAndName()).rank(new RankImpl());

        assertEquals(journalB, sortedJournals.get(0));
        assertEquals(journalC, sortedJournals.get(1));
        assertEquals(journalA, sortedJournals.get(2));


    }

    @Test
    public void rank_by_score_excluding_review_journals(){

        List<Journal> journals = new ArrayList<>();

        Journal journalA = new Journal();
        journalA.setJournalName("Journal A");
        journalA.setScore(5.6f);
        journalA.setReview(true);
        journals.add(journalA);

        Journal journalB = new Journal();
        journalB.setJournalName("Journal B");
        journalB.setScore(2.4f);
        journalB.setReview(false);
        journals.add(journalB);

        Journal journalC = new Journal();
        journalC.setJournalName("Journal C");
        journalC.setScore(3.1f);
        journalC.setReview(false);
        journals.add(journalC);

        SortOperator<Journal> sortedJournals = SortOperator.init(journals).filter(new FilterImpl()).sort(new CompareByScore()).rank(new RankImpl());

        assertEquals(journalC, sortedJournals.get(0));
        assertEquals(journalB, sortedJournals.get(1));
        assertEquals(2, sortedJournals.size());

    }

}
