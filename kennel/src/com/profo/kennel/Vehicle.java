package com.profo.kennel;

public class Vehicle {
    private Location currentLocation;
    private double maxFuelCapacity;
    private double currentFuel;
    private double milesPerGallon;

    public Vehicle(Location startLocation, double maxFuelCapacity, double milesPerGallon) {
        this.currentLocation = startLocation;
        this.maxFuelCapacity = maxFuelCapacity;
        this.currentFuel = maxFuelCapacity; // Start with a full tank
        this.milesPerGallon = milesPerGallon;
    }

    public boolean driveTo(Location destination) {
        double distance = currentLocation.getDistance(destination);
        double requiredFuel = distance / milesPerGallon;

        if (requiredFuel <= currentFuel) {
            currentFuel -= requiredFuel;
            currentLocation = destination;
            System.out.println("Driving to " + destination.getName() + "...");
            return true;
        } else {
            System.out.println("Not enough fuel to reach " + destination.getName() + ".");
            return false;
        }
    }

    public void refuel() {
        if (currentLocation.hasGasStation()) {
            currentFuel = maxFuelCapacity;
            System.out.println("Vehicle refueled to " + maxFuelCapacity + " gallons.");
        } else {
            System.out.println("No gas station at this location!");
        }
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}