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
    private final DoubleProperty il;

    public Materials(String nameMaterial, Double Cf, Double lamdaF, Double Tbf, Double il) {
        this.nameMaterial = new SimpleStringProperty(nameMaterial);
        this.Cf = new SimpleDoubleProperty(Cf);
        this.lamdaF = new SimpleDoubleProperty(lamdaF);
        this.Tbf = new SimpleDoubleProperty(Tbf);
        this.il = new SimpleDoubleProperty(il);
    }

    public String getNameMaterial() {
        return nameMaterial.get();
    }

    public StringProperty nameMaterialProperty() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial.set(nameMaterial);
    }

    public double getCf() {
        return Cf.get();
    }

    public DoubleProperty cfProperty() {
        return Cf;
    }

    public void setCf(double cf) {
        this.Cf.set(cf);
    }

    public double getLamdaF() {
        return lamdaF.get();
    }

    public DoubleProperty lamdaFProperty() {
        return lamdaF;
    }

    public void setLamdaF(double lamdaF) {
        this.lamdaF.set(lamdaF);
    }

    public double getTbf() {
        return Tbf.get();
    }

    public DoubleProperty tbfProperty() {
        return Tbf;
    }

    public void setTbf(double tbf) {
        this.Tbf.set(tbf);
    }

    public double getIl() {
        return il.get();
    }

    public DoubleProperty ilProperty() {
        return il;
    }

    public void setIl(double il) {
        this.il.set(il);
    }
}
