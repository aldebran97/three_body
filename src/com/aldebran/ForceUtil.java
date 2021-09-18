package com.aldebran;

import java.util.List;

/**
 * 力工具
 *
 * @author aldebran
 * @since 2021-09-17
 */
public class ForceUtil {

    /**
     * 计算每个小球收到的合力
     *
     * @param ballList 小球列表
     * @param K        万有引力系数
     */
    public static void CalcF(List<Ball> ballList, double K, double maxF) {
        for (int i = 0; i < ballList.size(); i++) {
            Vector F = new Vector(2);
            Ball b1 = ballList.get(i);
            for (int j = 0; j < ballList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Ball b2 = ballList.get(j);
                double r = Vector.distance(b1.position, b2.position); // 求两点之间的距离
                double subFNorm;
                if (r < b1.r + b2.r) {
                    // 对于有重叠的情况，应该分成三部分，然后用二重积分计算质心，然后计算3个万有引力的合力，质量取面积的比例即可，这里简化为0
                    subFNorm = 0;
                    System.out.println("" + i + " " + j + " 重叠");
                } else {
                    subFNorm = K * b1.m * b2.m / (r * r); // 求万有引力的大小
                }
                if (subFNorm > maxF) {
                    subFNorm = maxF + Math.log(1 + Math.abs(subFNorm - maxF));
                }
                Vector subFDirection = Vector.sub(b2.position, b1.position); // 求力的方向
                Vector subF = new Vector(subFDirection, subFNorm); // 求分力向量
                F = Vector.add(F, subF); // 力的合成
            }
            b1.F = F;
        }
    }

    /**
     * 小球移动
     *
     * @param ballList 小球列表
     * @param interval 时间间隔
     */
    public static void CalcX(List<Ball> ballList, double interval) {
        for (Ball b : ballList) {
            b.position = Vector.add(b.position, Vector.mul(b.v, interval));
        }
        while (detectCrash(ballList)) ;
    }

    public static boolean detectCrash(List<Ball> ballList) {
        for (int i = 0; i < ballList.size(); i++) {
            Ball b1 = ballList.get(i);
            for (int j = 0; j < ballList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Ball b2 = ballList.get(j);
                double r = Vector.distance(b1.position, b2.position); // 求两点之间的距离
                if (r < b1.r + b2.r) {
                    // 合一，动量守恒，动能损失
                    b1.v = Vector.div(Vector.add(Vector.mul(b1.v, b1.m), Vector.mul(b2.v, b2.m)), b1.m + b2.m);
                    b1.m = b1.m + b2.m;
                    ballList.remove(j);
                    System.out.println("检测到碰撞");
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 更新速度
     *
     * @param ballList 小球列表
     * @param interval 时间间隔
     */
    public static void CalcV(List<Ball> ballList, double interval) {
        for (Ball b : ballList) {
            Vector a = Vector.mul(b.F, 1.0 / b.m); // 计算加速度
            b.v = Vector.add(b.v, Vector.mul(a, interval)); // 更新速度
        }
    }

}
