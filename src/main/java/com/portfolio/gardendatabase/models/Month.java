package com.portfolio.gardendatabase.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Month extends AbstractEntity {
    @NotNull
    private String location;

    @OneToMany
    @JoinColumn(name = "month_id")
    private List<Plant> plants = new ArrayList<>();

    //getters and setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
