package com.aldebran;

import java.awt.*;

/**
 * 小球
 *
 * @author aldebran
 * @since 2021-09-17
 */
public class Ball {

    public Vector position = new Vector(2); // 位置

    public Vector v = new Vector(2); // 速度

    public Vector F = new Vector(2); // 外力（万有引力）

    public double m = 1; // 质量

    public double r = 0.05; // 半径

    public Color color = Color.BLACK; // 颜色

    public Ball() {

    }

    /**
     * 构造方法
     *
     * @param m        质量
     * @param position 位置
     */
    public Ball(double m, Vector position) {
        this.m = m;
        this.position = position;
    }

    /**
     * 构造方法
     *
     * @param m        质量
     * @param position 位置
     * @param v        速度
     */
    public Ball(double m, Vector position, Vector v) {
        this.m = m;
        this.position = position;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "position=" + position +
                ", v=" + v +
                ", F=" + F +
                ", m=" + m +
                '}';
    }
}
