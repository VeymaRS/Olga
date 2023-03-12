package com.weymar87;

import com.weymar87.base.Soils;

public class Interpolation {

    public double linearInterpolationForPressure(double[][] arr, double T, double depth, Soils soil) {
        double result = 0;
        int[] row;
        if (soil.getIl() < 0.2) {
            if (soil.getSoilTypes().equals("Крупно-обломочные")) {
                row = new int[]{1};
                result = interpolationForTemperature(arr, row[0], T);
            } else if (soil.getSoilTypes().equals("Пески крупные и средней крупности")) {
                row = new int[]{2};
                result = interpolationForTemperature(arr, row[0], T);
            } else if (soil.getSoilTypes().equals("Пески мелкие и пылеватые")) {
                row = new int[]{3, 4, 5};
                if (depth >= 3 & depth <= 5) {
                    result = interpolationForTemperature(arr, row[0], T);
                } else if (depth > 5 & depth <= 10) {
                    double value1 = interpolationForTemperature(arr, row[0], T);
                    double value2 = interpolationForTemperature(arr, row[1], T);
                    result = interpolationForDepth(5, 10, depth, value1, value2);
                } else if (depth > 10 & depth <= 15) {
                    double value1 = interpolationForTemperature(arr, row[1], T);
                    double value2 = interpolationForTemperature(arr, row[2], T);
                    result = interpolationForDepth(10, 15, depth, value1, value2);
                } else if (depth > 15) {
                    result = interpolationForTemperature(arr, row[2], T);
                }

            } else if (soil.getSoilTypes().equals("Супеси")) {
                row = new int[]{6, 7, 8};
            } else if (soil.getSoilTypes().equals("Суглинки и глины")) {
                row = new int[]{9, 10, 11};
            }
        }
        return result;
    }

    public double interpolationForTemperature(double[][] arr, int row, double T) {
        double result = 0;
        if (T > arr[0][arr[0].length - 1] & T < arr[0][0]) {
            for (int i = 0; i < arr[0].length; i++) {
                if (T <= arr[0][i] & T >= arr[0][i + 1]) {
                    double x2 = arr[0][i + 1];
                    double x1 = arr[0][i];
                    double y2 = arr[row][i + 1];
                    double y1 = arr[row][i];
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

    public double interpolationForDepth(double x1, double x2, double x, double y1, double y2) {
        double result = 0;
        double alpha = (y2 - y1) / (x2 - x1);
        double beta = y1 - alpha * x1;
        result = alpha * x + beta;
        return result;
    }
}
