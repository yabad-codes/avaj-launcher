package ma.leet.avaj.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ma.leet.avaj.aircraft.Flyable;
import ma.leet.avaj.factory.AircraftFactory;
import ma.leet.avaj.tower.WeatherTower;
import ma.leet.avaj.weather.Coordinates;

public class Simulation {
    public static void main(String[] args) {
        // Create a weather tower
        WeatherTower weatherTower = new WeatherTower();

        // Check if the number of arguments is valid
        if (args.length != 1) {
            System.err.println("Please provide the scenario file path");
            System.exit(-1);
        }

        // Open the scenario file
        File file = new File(args[0]);

        if (!file.exists()) {
            System.err.println("File not found: " + args[0]);
            System.exit(-1);
        }

        // Read the scenario file
        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNext()) {
                System.err.println("Scenario file is empty");
                System.exit(-1);
            }

            // Read the first line of the scenario file
            int simulations = scanner.nextInt();
            scanner.nextLine();

            // Check if the number of simulations is valid
            if (simulations < 0) {
                System.err.println("Invalid number of simulations: " + simulations);
                System.exit(-1);
            }

            // Read the rest of the scenario file
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                // Check if the line is empty
                if (line.isEmpty())
                    continue;

                // Split the line into tokens
                String[] tokens = line.split(" ");

                // Check if the number of tokens is valid
                if (tokens.length != 5) {
                    System.err.println("Invalid number of params: " + tokens.length);
                    System.exit(-1);
                }

                // Parse the tokens
                String type = tokens[0];
                String name = tokens[1];
                int longitude = Integer.parseInt(tokens[2]);
                int latitude = Integer.parseInt(tokens[3]);
                int height = Integer.parseInt(tokens[4]);
                Coordinates coordinates = new Coordinates(longitude, latitude, height);

                // Create the flyable aircraft
                Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, coordinates);

                // Register the flyable aircraft
                if (aircraft != null)
                    aircraft.registerTower(weatherTower);
            }

            // Simulate the weather
            for (int i = 0; i < simulations; i++)
                weatherTower.changeWeather();
        } catch (FileNotFoundException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
            System.exit(-1);
        }
    }
}