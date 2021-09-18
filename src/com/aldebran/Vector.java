package com.aldebran;

import java.util.Arrays;

/**
 * 向量
 *
 * @author aldebran
 * @since 2021-09-17
 */
public class Vector {

    private double[] a; // 内部数组

    // 指定向量长度
    public Vector(int length) {
        a = new double[length];
    }

    // 由一组浮点数确定向量
    public Vector(double... a) {
        this.a = a;
    }

    // 由向量的模和方向确定向量
    public Vector(Vector direction, double norm) {
        int n = direction.length();
        double directionNorm = direction.norm();
        this.a = new double[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = direction.get(i) * norm / directionNorm;
        }
    }

    // 向量长度
    public int length() {
        return a.length;
    }

    // 获取指定位置的值
    public double get(int index) {
        return a[index];
    }

    // 设置指定位置的值
    public void set(int index, double v) {
        a[index] = v;
    }

    // 向量加法
    public static Vector add(Vector v1, Vector v2) {
        Vector v3 = new Vector(v1.length());
        int n = v1.length();
        for (int i = 0; i < n; i++) {
            v3.set(i, v1.get(i) + v2.get(i));
        }
        return v3;
    }

    // 向量减法
    public static Vector sub(Vector v1, Vector v2) {
        Vector v3 = new Vector(v1.length());
        int n = v1.length();
        for (int i = 0; i < n; i++) {
            v3.set(i, v1.get(i) - v2.get(i));
        }
        return v3;
    }

    // 向量数乘
    public static Vector mul(Vector v, double a) {
        Vector v3 = new Vector(v.length());
        int n = v.length();
        for (int i = 0; i < n; i++) {
            v3.set(i, v.get(i) * a);
        }
        return v3;
    }

    // 向量数除
    public static Vector div(Vector v, double a) {
        return mul(v, 1 / a);
    }

    // 向量的模
    public double norm() {
        double s = 0;
        int n = length();
        for (int i = 0; i < n; i++) {
            s += a[i] * a[i];
        }
        return Math.sqrt(s);
    }

    // 点之间的距离
    public static double distance(Vector v1, Vector v2) {
        Vector v3 = Vector.sub(v1, v2);
        return v3.norm();
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }
}
