package com.weymar87.base;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Materials {
    private final StringProperty nameMaterial;
    private final DoubleProperty Cf;
    private final DoubleProperty lamdaF;
    private final DoubleProperty Tbf;

    public Materials(String nameMaterial, Double Cf, Double lamdaF, Double Tbf) {
        this.nameMaterial = new SimpleStringProperty(nameMaterial);
        this.Cf = new SimpleDoubleProperty(Cf);
        this.lamdaF = new SimpleDoubleProperty(lamdaF);
        this.Tbf = new SimpleDoubleProperty(Tbf);
    }
}
