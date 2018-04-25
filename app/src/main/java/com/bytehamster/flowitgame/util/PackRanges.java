package com.bytehamster.flowitgame.util;

import java.util.ArrayList;

public class PackRanges {
    private PackRanges() {

    }

    public static final int[][] RANGE_1 = new int[][]{
            new int[]{0, 13},
            new int[]{15, 16},
            new int[]{18, 19},
            new int[]{25, 29},
            new int[]{31, 31},
            new int[]{33, 33},
            new int[]{35, 36},
            new int[]{50, 53},
            new int[]{75, 76},
            new int[]{84, 84},
            new int[]{100, 100},
    };
    public static final int[][] RANGE_2 = new int[][]{
            new int[]{14, 14},
            new int[]{17, 17},
    };
    public static final int[][] RANGE_3 = new int[][]{
            new int[]{20, 24},
            new int[]{30, 30},
            new int[]{32, 32},
            new int[]{34, 34},
            new int[]{37, 49},
            new int[]{54, 74},
            new int[]{77, 83},
            new int[]{85, 99},
            new int[]{101, 102}
    };


    private static final ArrayList<int[]> ANOMALIES = calculateAnomalies();

    private static ArrayList<int[]> calculateAnomalies() {
        ArrayList<int[]> result = new ArrayList<>();
        result.addAll(calculateAnomalies(RANGE_1));
        result.addAll(calculateAnomalies(RANGE_2));
        result.addAll(calculateAnomalies(RANGE_3));
        return result;
    }

    private static ArrayList<int[]> calculateAnomalies(int[][] pack) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < pack.length - 1; i++) {
            result.add(new int[]{pack[i][1], pack[i+1][0]});
        }
        return result;
    }

    private static int firstOf(int [][] pack) {
        return pack[0][0];
    }

    public static boolean isFirstInPack(int level) {
        return level == firstOf(RANGE_1) || level == firstOf(RANGE_2) || level == firstOf(RANGE_3);
    }

    private static int lastOf(int [][] pack) {
        return pack[pack.length - 1][1];
    }

    public static boolean isLastInPack(int level) {
        return level == lastOf(RANGE_1) || level == lastOf(RANGE_2) || level == lastOf(RANGE_3);
    }

    public static int previousLevel(int level) {
        for (int[] anomaly : ANOMALIES) {
            if (anomaly[1] == level) {
                return anomaly[0];
            }
        }
        return level - 1;
    }

    public static int nextLevel(int level) {
        for (int[] anomaly : ANOMALIES) {
            if (anomaly[0] == level) {
                return anomaly[1];
            }
        }
        return level + 1;
    }
}
