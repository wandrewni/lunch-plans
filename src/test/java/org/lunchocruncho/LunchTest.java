package org.lunchocruncho;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LunchTest {
    @Test
    public void weAreGoingToWestside() {
        assertEquals("Today is not a westside day", LunchPlans.todaysPlan(), LunchPlan.WESTSIDE);
    }
}
