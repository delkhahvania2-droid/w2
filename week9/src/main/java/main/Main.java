package main;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //singleton
        ChampionshipManager manager = ChampionshipManager.getInstance();

        
        GravelCar gravelCar   = new GravelCar("Hyundai", "i20 N",       380, 150);
        AsphaltCar asphaltCar = new AsphaltCar("Ford",   "Puma Rally1", 500, 12.5);

        
        Driver ogier     = new Driver("Sebastien Ogier",  "France",  0, gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanpera",  "Finland", 0, gravelCar);
        Driver tanak     = new Driver("Ott Tanak",        "Estonia", 0, gravelCar);
        Driver neuville  = new Driver("Thierry Neuville", "England", 0, gravelCar);
// register drivers in championship manager
        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);
//race 1: gravel
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland (Jyväskylä)", "Gravel");
        race1.recordResult(ogier,     1, 25);
        race1.recordResult(tanak,     2, 18);
        race1.recordResult(rovanpera, 3, 15);
        race1.recordResult(neuville,  4, 12);
        manager.addRaceResult(race1);

       //switch all drivers to asphalt cars 
        ogier.setCar(asphaltCar);
        rovanpera.setCar(asphaltCar);
        tanak.setCar(asphaltCar);
        neuville.setCar(asphaltCar);

        // race 2: asphalt
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally (Monaco)", "Asphalt");
        race2.recordResult(rovanpera, 1, 25);
        race2.recordResult(neuville,  2, 18);
        race2.recordResult(ogier,     3, 15);
        race2.recordResult(tanak,     4, 12);
        manager.addRaceResult(race2);

        //standings
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        List<Driver> standings = manager.getDriverStandings();
        int rank = 1;
        for (Driver d : standings) {
            System.out.println(rank + ". " + d.getName()
                    + " (" + d.getCountry() + "): "
                    + d.getPoints() + " points");
            rank++;
        }

        // here is the championship leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        }

        //stat
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: "  + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: "    + ChampionshipManager.getTotalRaces());

        // Round average 
        double avg = ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings());
        String avgFormatted = String.format("%.2f", avg);
        System.out.println("Average Points Per Driver: " + avgFormatted);

        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: "
                + ChampionshipManager.getTotalChampionshipPoints());

       //race results
        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("\nRace: " + race.getRaceName());
            for ( Driver d : race.getResults()) {
                System.out.println(d.getName() + " - Position: " + race.getDriverPosition(d) + ", Points: " + race.getDriverPoints(d));
            }
        }

        //performance ratings
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: "  + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}