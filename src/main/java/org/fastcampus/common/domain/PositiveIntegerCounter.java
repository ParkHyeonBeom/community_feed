package org.fastcampus.common.domain;

public class PositiveIntegerCounter {

    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    public PositiveIntegerCounter(int count) {
        this.count = count;
    }

    public int increaseCount() {
        return this.count++;
    }

    public int decreaseCount() {
        if( count <= 0 ){
            return count;
        }
        return this.count--;
    }

    public int getCount() {
        return count;
    }
}
