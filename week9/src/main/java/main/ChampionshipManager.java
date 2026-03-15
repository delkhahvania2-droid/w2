package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers;
    private List<RallyRaceResult> raceResults;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result) {
        raceResults.add(result);
        totalRaces++;
    }

    public static Driver getLeadingDriver() {
        return getInstance().drivers.stream().max(Comparator.comparingInt(Driver::getPoints))
        .orElse(null);
    }

    public List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return standings;
    }

    
    public static int getTotalChampionshipPoints() {
        int total = 0;
        for (Driver driver : getInstance().drivers) {
            total += driver.getPoints();
        }
        return total;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public List<RallyRaceResult> getRaceResults() {
        return raceResults;
    }
}