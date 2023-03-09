package com.weymar87.base;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SigmaBaseRow {
    private StringProperty meteostation;
    private DoubleProperty latitude;
    private DoubleProperty longtitude;
    private DoubleProperty sigma;


    public SigmaBaseRow(String meteostation, Double latitude, Double longtitude, Double sigma) {
        this.meteostation = new SimpleStringProperty(meteostation);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.longtitude = new SimpleDoubleProperty(longtitude);
        this.sigma = new SimpleDoubleProperty(sigma);
    }

    public String getMeteostation() {
        return meteostation.get();
    }

    public StringProperty meteostationProperty() {
        return meteostation;
    }

    public void setMeteostation(String meteostation) {
        this.meteostation.set(meteostation);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public DoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }

    public double getLongtitude() {
        return longtitude.get();
    }

    public DoubleProperty longtitudeProperty() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude.set(longtitude);
    }

    public double getSigma() {
        return sigma.get();
    }

    public DoubleProperty sigmaProperty() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma.set(sigma);
    }
}
