package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    private ChampionshipStatistics() {}

    // calculateAveragePointsPerDriver
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) return 0.0;
        int total = 0;
        for (Driver d : drivers) {
            total += d.getPoints();
        }
        return (double) total / drivers.size();
    }

    // findMostSuccessfulCountry
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) return "N/A";

        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver d : drivers) {
             if (countryPoints.containsKey(d.getCountry())) {
                    countryPoints.put(d.getCountry(), countryPoints.get(d.getCountry()) + d.getPoints());
                    } else {
                        countryPoints.put(d.getCountry(), d.getPoints());
                    }
        }

        String topCountry = null;
        int topPoints = -1;
        //-1 is chosen to ensure that even countries with 0 points can be considered 
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > topPoints) {
                topPoints = entry.getValue();
                topCountry = entry.getKey();
            }
        }
        return topCountry;
    }

    //getTotalRacesHeld
    public static int getTotalRacesHeld(List<RallyRaceResult> results) {
        return results == null ? 0 : results.size();
    }
}