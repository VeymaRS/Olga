package com.weymar87.base;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Hole {
    private final DoubleProperty soilWidth;
    private final Soils soil;

    public Hole(Double soilWidth, Soils soil) {
        this.soilWidth = new SimpleDoubleProperty(soilWidth);
        this.soil = soil;
    }

    public double getSoilWidth() {
        return soilWidth.get();
    }

    public DoubleProperty soilWidthProperty() {
        return soilWidth;
    }

    public void setSoilWidth(double soilWidth) {
        this.soilWidth.set(soilWidth);
    }

    public Soils getSoil() {
        return soil;
    }
}
