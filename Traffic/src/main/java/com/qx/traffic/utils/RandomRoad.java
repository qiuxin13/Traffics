package com.qx.traffic.utils;

import java.util.Random;

public class RandomRoad {
    private static int roadNum = 20;

    public RandomRoad() {
    }

    public RandomRoad(int roadNum) {
        RandomRoad.roadNum = roadNum;
    }

    /**
     *按照正态分布生成随机数，随机不同路况
     * @return
     */
    public static int generateRandom() {
        Random rand = new Random();
        double mean =roadNum / 2.0;
        double stddev = roadNum / 6.0; // 选择标准差，使得大部分值在0到n范围内

        // 使用Box-Muller变换生成标准正态分布随机数
        double u1 = rand.nextDouble();
        double u2 = rand.nextDouble();
        double z = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI *u2);

        // 将标准正态分布随机数缩放和平移
        int result = (int) Math.round(mean + stddev * z);

        // 确保结果在0到n范围内
        if (result < 0) {
            result = 0;
        } else if (result > roadNum) {
            result =roadNum;
        }

        return result;
    }
}
