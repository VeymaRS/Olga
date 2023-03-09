package com.weymar87.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SigmaBase {
    private ObservableList<SigmaBaseRow> sigmaBase = FXCollections.observableArrayList();

    public ObservableList<SigmaBaseRow> getSigmaBase() {
        return sigmaBase;
    }
    public SigmaBase() {
        //Красноярский край
        sigmaBase.add(new SigmaBaseRow("Дудинка", 69.5, 86.3, 1.35));
        sigmaBase.add(new SigmaBaseRow("Им. Е.К. Федорова", 77.7, 104.3, 1.11));
        sigmaBase.add(new SigmaBaseRow("о. Голомянный", 79.6, 90.6, 0.98));
        sigmaBase.add(new SigmaBaseRow("о. Диксон", 73.5, 80.2, 1.33));
        //Ханты-Мансийский автономный округ
        sigmaBase.add(new SigmaBaseRow("Сургут", 61.4, 73.5, 1.16));
        sigmaBase.add(new SigmaBaseRow("Ханты-Мансийск}", 61.1, 69.1, 1.10));
        //Ямало-Ненецкий автономный округ
        sigmaBase.add(new SigmaBaseRow("Гыдояма", 70.9, 78.5, 1.40));
        sigmaBase.add(new SigmaBaseRow("Марре-Сале", 69.7, 66.8, 1.39));
        sigmaBase.add(new SigmaBaseRow("Надым", 65.6, 72.5, 1.22));
        sigmaBase.add(new SigmaBaseRow("о. Белый", 73.3, 70.7, 1.47));
        sigmaBase.add(new SigmaBaseRow("Ныда", 66.6, 73.0, 1.46));
        sigmaBase.add(new SigmaBaseRow("Полуй", 66.0, 68.7, 1.44));
        sigmaBase.add(new SigmaBaseRow("Салехард", 66.6, 66.6, 1.46));
        sigmaBase.add(new SigmaBaseRow("Тазовский", 67.5, 78.8, 1.33));
        sigmaBase.add(new SigmaBaseRow("Тамбей", 71.5, 71.8, 1.14));
        sigmaBase.add(new SigmaBaseRow("Тарко-Сале", 64.9, 77.8, 1.27));
        sigmaBase.add(new SigmaBaseRow("Уренгой", 66.0, 78.4, 1.5));
        sigmaBase.add(new SigmaBaseRow("Харасавэй", 71.2, 66.9, 1.59));
    }
}
