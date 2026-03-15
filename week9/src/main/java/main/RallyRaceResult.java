package main;

import java.util.ArrayList;
import java.util.List;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String surface;

    private static class ResultEntry {
        Driver driver;
        int position;
        int points;

        ResultEntry(Driver driver, int position, int points) {
            this.driver   = driver;
            this.position = position;
            this.points   = points;
        }
    }

    private List<ResultEntry> entries;

    public RallyRaceResult(String raceName, String surface) {
        this.raceName = raceName;
        this.surface  = surface;
        this.entries  = new ArrayList<>();
    }

    public String getRaceName() {
     
         return raceName; 

     }
    public String getSurface()
      { return surface; }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        entries.add(new ResultEntry(driver, position, points));
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        for (ResultEntry entry : entries) {
            if (entry.driver == driver) return entry.points;
        }
        return 0;
    }

    // Returns List<Driver> to match interface — position is infred from order in list
    @Override
    public List<Driver> getResults() {
        List<Driver> results = new ArrayList<>();
        for (ResultEntry entry : entries) {
            results.add(entry.driver);
        }
        return results;
    }

    // Helper method to get position of a driver in this race
    public int getDriverPosition(Driver driver) {
        for (ResultEntry entry : entries) {
            if (entry.driver == driver) return entry.position;
        }
        return -1;
        //-1 indicates driver not found because positions start from 1
    }
}