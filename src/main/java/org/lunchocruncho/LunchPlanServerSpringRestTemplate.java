package org.lunchocruncho;

import org.springframework.web.client.RestTemplate;

public class LunchPlanServerSpringRestTemplate implements LunchPlanLookup {
    private static final String TODAYS_LUNCH_PLAN_URL = "http://super-lunch-plans.com/todaysPlan";

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public LunchPlan lookupTodaysLunchPlan() {
        final String lunchPlanServerResponse = getLunchPlanServerResponse();
        if ("WESTSIDE".equals(lunchPlanServerResponse))
            return LunchPlan.WESTSIDE;
        else
            return LunchPlan.NOT_WESTSIDE;
    }

    private String getLunchPlanServerResponse() {
        return restTemplate.getForObject(TODAYS_LUNCH_PLAN_URL, String.class);
    }
}
