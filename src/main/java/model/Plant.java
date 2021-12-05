package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Plant extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;

    @ManyToOne
    @JoinColumn(name = "height_id")
    private Height height;

    @ManyToMany
    private java.util.List<Color> colors;

    public Plant() {
    }

    public Plant(Month aMonth, List<Color> someColors, Height aHeight) {
        super();
        this.month = aMonth;
        this.colors = someColors;
        this.height = aHeight;
    }

    //getters and setters
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Color> getColor() {
        return colors;
    }

    public void setColor(List<Color> colors) {
        this.colors = colors;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
}
