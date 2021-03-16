package com.StarWarsAPI.WebService;

import java.util.List;

public class dadosAPI {

    private String   name;
    private String   rotation_period;
    private String   orbital_period;
    private String   diameter;
    private String   climate;
    private String   gravity;
    private String   terrain;
    private String   surface_water;
    private String   population;
    private List<String> residents;

    public String getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }



    public List<String> getResidents() {
        return residents;
    }

    @Override
    public String toString() {
        return "{}" ;
    }
}
