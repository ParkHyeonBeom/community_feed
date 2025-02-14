package org.fastcampus.post.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostiveIntegerCounterTest {

    @Test
    public void givenCreated_whenIncreased_thenCountIsOne() {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.increaseCount();
        // then
        Assertions.assertEquals(1, counter.getCount());
    }

    @Test
    public void givenCretedAndIncreased_whenDecreased_thenCountIs0() {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increaseCount();
        // when
        counter.decreaseCount();
        // then
        Assertions.assertEquals(0, counter.getCount());
    }

    @Test
    public void givenClicked_whenDecreased_thenUnderCount0() {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.decreaseCount();
        // then
        Assertions.assertEquals(0, counter.getCount());
    }

}
