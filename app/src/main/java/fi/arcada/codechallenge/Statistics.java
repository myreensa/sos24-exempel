package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static double calcMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        int midIndex = sorted.size() / 2;

        if (sorted.size() % 2 == 0) {
            return (sorted.get(midIndex - 1) + sorted.get(midIndex)) / 2.0;
        } else {

            return sorted.get(midIndex);
        }
    }

    public static double calcMean(ArrayList<Double> values) {
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public static double calculateStDev(double[] array) {
        double sum = 0.0;
        for(double i : array) {
            sum += i;
        }

        int length = array.length;
        double mean = sum / length;

        double StDev = 0.0;
        for (double num : array) {
            StDev += Math.pow(num - mean, 2);
        }

        return Math.sqrt(StDev / length);
    }



    public static double calcLq(ArrayList<Double> values)  {
            ArrayList<Double> sorted = new ArrayList<>(values);
            Collections.sort(sorted);

            double lowIndex = sorted.size() * 0.25;

            if (sorted.size() % 2 == 0) {
                int lowIndexInt = (int) lowIndex;
                return (sorted.get(lowIndexInt - 1) + sorted.get(lowIndexInt)) / 2.0;
            } else {
                return sorted.get((int) lowIndex);
            }
        }



    public static double calcHq(ArrayList<Double> values)  {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        double highIndex = sorted.size() * 0.75;


        if (sorted.size() % 2 == 0) {
            int highIndexInt = (int) highIndex;
            return (sorted.get(highIndexInt + 1) + sorted.get(highIndexInt)) / 2.0;
        } else {
            return sorted.get((int) highIndex);
        }
    }

    public static double calcIQR(ArrayList<Double> values) {
        double lowerQuartile = calcLq(values);
        double upperQuartile = calcHq(values);
        return upperQuartile - lowerQuartile;
    }

    }
