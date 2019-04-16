package org.lunchocruncho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LunchPlanServerVanillaJava implements LunchPlanLookup {

    public static final String TODAYS_LUNCH_PLAN_URL = "http://super-lunch-plans.com/todaysPlan";

    @Override
    public LunchPlan lookupTodaysLunchPlan() {
        try {
            final String lunchPlanServerResponse = getLunchPlanServerResponse();
            if ("WESTSIDE".equals(lunchPlanServerResponse))
                return LunchPlan.WESTSIDE;
            else
                return LunchPlan.NOT_WESTSIDE;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLunchPlanServerResponse() throws IOException{
        final URL url = new URL(TODAYS_LUNCH_PLAN_URL);
        final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        final InputStream content = httpURLConnection.getInputStream();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
        StringBuilder finalContent = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null)
            finalContent.append(line).append("\n");
        return finalContent.toString();
    }
}
