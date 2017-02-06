package com.f1000.entity;


/**
 * Created by zhuanghua on 2017/2/6.
 */
public class Journal{

    private int rank;
    private String journalName;
    private float score;
    private boolean isReview;


    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public boolean isReview() {
        return isReview;
    }

    public void setReview(boolean review) {
        isReview = review;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int hashCode() {
        final int seed = 77;
        return ((journalName == null) ? 0 : journalName.hashCode())+(isReview ? 22 : 333)+(int) (seed * score);

    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Journal other = (Journal) obj;
        if (journalName == null) {
            if (other.journalName != null)
                return false;
        } else if (!journalName.equals(other.journalName))
            return false;
        if (isReview != other.isReview)
            return false;
        if (score != other.score)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journalName='" + journalName + '\'' +
                ", score=" + score +
                ", isReview=" + isReview +
                ", rank=" + rank +
                '}';
    }
}
