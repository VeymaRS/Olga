package com.weymar87;

import com.weymar87.base.SoilTypes;
import com.weymar87.base.Soils;

public class Interpolation {

    public double linearInterpolationForPressure(double[][] arr, double T, double depth, Soils soil) {
        double result = 0;
        int[] row;
        if (soil.getIl() < 0.2) {
            if (soil.getNameMaterial().equals("Крупно-обломочные")) {
                row = new int[]{1};
            } else if (soil.getNameMaterial().equals("Пески крупные и средней крупности")) {
                row = new int[]{2};
            } else if (soil.getNameMaterial().equals("Пески мелкие и пылеватые")) {
                row = new int[]{3, 4, 5};
            } else if (soil.getNameMaterial().equals("Супеси")) {
                row = new int[]{6, 7, 8};
            } else if (soil.getNameMaterial().equals("Суглинки и глины")) {
                row = new int[]{9, 10, 11};
            }

        }
        return result;
    }

    public Double biLinearInterpolation() {
        double result = 0;
        return result;
    }

    public double interpolation(double[][] arr, double T) {
        double result = 0;
        if (T > arr[0][arr[0].length - 1] & T < arr[0][0]) {
            for (int i = 0; i < arr[0].length; i++) {
                if (T <= arr[0][i] & T >= arr[0][i + 1]) {
                    double x2 = arr[0][i + 1];
                    double x1 = arr[0][i];
                    double y2 = arr[1][i + 1];
                    double y1 = arr[1][i];
                    double alpha = (y2 - y1) / (x2 - x1);
                    double beta = y1 - alpha * x1;
                    result = alpha * T + beta;
                    break;
                }
            }
        } else if (T == arr[0][0]) {
            result = arr[1][0];
        } else if (T <= arr[0][arr[0].length - 1]) {
            result = arr[1][arr[0].length - 1];
        }
        return result;
    }

}
