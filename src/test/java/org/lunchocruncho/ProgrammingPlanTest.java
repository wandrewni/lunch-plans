package org.lunchocruncho;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProgrammingPlanTest {
    @Test
    public void weAreProgrammingThursday() {
        ProgramPlan thisWeeksPlan = ProgramPlan.thisWeeksPlan();
        assertTrue("This week is programming week", thisWeeksPlan.equals(ProgramPlan.THURSDAY));
    }
}
