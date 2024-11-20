package com.profo.kennel;

public class Location {
    private String name;
    private int x, y;
    private boolean hasGas;

    public Location(String name, int x, int y, boolean hasGas) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hasGas = hasGas;
    }

    public String getName() {
        return name;
    }

    public boolean hasGasStation() {
        return hasGas;
    }

    public double getDistance(Location other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}