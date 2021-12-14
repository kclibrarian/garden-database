package com.portfolio.gardendatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Color extends AbstractEntity{
    @NotNull
    @Size(min=1, max=50)
    private String description;

    @ManyToMany(mappedBy = "colors")
    @NotNull
    @Size(min=1, max=50)
    private List<Plant> plants = new ArrayList<>();

    public Color() {

    }

    //getters and setters


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
