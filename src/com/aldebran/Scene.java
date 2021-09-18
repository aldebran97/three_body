package com.aldebran;

import java.util.ArrayList;
import java.util.List;

/**
 * 2D场景
 *
 * @author aldebran
 * @since 2021-09-17
 */
public class Scene {

    public List<Ball> ballList = new ArrayList<>(); // 球列表

    public double interval = 0.5; // 时间间隔

    public double maxF = 5; // 力削弱阀值

    public double K = 1; // 模拟的万有引力系数

    // 坐标系信息

    public double xMax = 100;

    public double xMin = -100;

    public double yMin = -100;

    public double yMax = 100;

    public ShowFrame showFrame;

    public Scene() {

    }

    public Scene(double w, double h) {
        setHeight(h);
        setWidth(w);
    }

    public void setWidth(double w) {
        xMax = w / 2.0;
        xMin = -xMax;
    }

    public void setHeight(double h) {
        yMax = h / 2.0;
        yMin = -yMax;
    }

    public double getWidth() {
        return xMax - xMin;
    }

    public double getHeight() {
        return yMax - yMin;
    }

    // 和显示窗体双向绑定
    public void bind(ShowFrame showFrame) {
        this.showFrame = showFrame;
        showFrame.scene = this;
        showFrame.setVisible(true);
    }

    // 自动运行
    public void run() {
        while (true) {
            if (showFrame != null) {
                showFrame.jPanel.repaint();
            }
            next();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 运动一次
    public void next() {
        ForceUtil.CalcX(ballList, interval);
        ForceUtil.CalcF(ballList, K, maxF);
        ForceUtil.CalcV(ballList, interval);
        System.out.println(ballList);
    }
}
