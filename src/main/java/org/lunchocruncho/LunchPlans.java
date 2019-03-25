package org.lunchocruncho;

public class LunchPlans {
    public static LunchPlan todaysPlan() {
        return setTodaysPlan("Today");
    }

    public static LunchPlan setTodaysPlan(String day) {
        switch (day){
            case "Today":
                return LunchPlan.WESTSIDE;
            case "Not_Today":
                return LunchPlan.NOT_WESTSIDE;
            default:
                return null;
        }
    }
}
