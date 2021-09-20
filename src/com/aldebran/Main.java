package com.aldebran;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        oneFixStars();
//        threeFixedStarsTwoPlanets();
//        threeFixedStarsOnePlanet();
        threeBody();
    }

    // 三恒星+双行星
    public static void threeFixedStarsTwoPlanets() {
        // 创建宽和高均为3200的坐标系
        Scene scene = new Scene(3200, 3200);
        // 设置delta-t，越大越快
        scene.interval = 1;
        // 恒星1
        scene.ballList.add(new Ball(5000, new Vector(50, 0), new Vector(-0.3, -0.8)));
        // 恒星2
        scene.ballList.add(new Ball(6000, new Vector(-50, 0), new Vector(0.1, 0.65)));
        // 恒星3
        scene.ballList.add(new Ball(8000, new Vector(0, 50), new Vector(0.05, -0.0)));
        // 行星1
        scene.ballList.add(new Ball(2.2, new Vector(-200, 200), new Vector(7, 7)));
        // 行星2
        scene.ballList.add(new Ball(200, new Vector(800, -800), new Vector(-3, -3)));
        // 行星1颜色为红色
        scene.ballList.get(3).color = Color.RED;
        // 行星2颜色为绿色
        scene.ballList.get(4).color = Color.GREEN;
        // 创建显示窗体（一切默认）
        ShowFrame showFrame = new ShowFrame();
        // 绑定
        scene.bind(showFrame);
        // 开始运行
        scene.run();
    }

    // 三恒星+单行星
    public static void threeFixedStarsOnePlanet() {
        // 创建宽和高均为3200的坐标系
        Scene scene = new Scene(400, 400);
        // 设置delta-t，越大越快
        scene.interval = 0.05;
        // 恒星1
        scene.ballList.add(new Ball(5000, new Vector(50, 0), new Vector(-0.3, -0.8)));
        // 恒星2
        scene.ballList.add(new Ball(6000, new Vector(-50, 0), new Vector(0.1, 0.65)));
        // 恒星3
        scene.ballList.add(new Ball(8000, new Vector(0, 50), new Vector(0.05, -0.0)));
        // 行星1
        scene.ballList.add(new Ball(2.2, new Vector(-50, 50), new Vector(7, 7)));
        // 行星1颜色为红色
        scene.ballList.get(3).color = Color.RED;
        // 创建显示窗体（一切默认）
        ShowFrame showFrame = new ShowFrame();
        // 绑定
        scene.bind(showFrame);
        // 开始运行
        scene.run();
    }

    // 单恒星
    public static void oneFixStars() {
        // 创建宽和高均为3200的坐标系
        Scene scene = new Scene(3200, 3200);
        // 设置delta-t，越大越快
        scene.interval = 1;
        // 恒星
        scene.ballList.add(new Ball(6000, new Vector(50, 0)));
        // 行星1
        scene.ballList.add(new Ball(2.2, new Vector(-200, 200), new Vector(3, 3)));
        // 行星2
        scene.ballList.add(new Ball(200, new Vector(800, -800), new Vector(-1.5, -1.5)));
        // 行星1颜色为红色
        scene.ballList.get(1).color = Color.RED;
        // 行星2颜色为绿色
        scene.ballList.get(2).color = Color.GREEN;
        // 创建显示窗体（一切默认）
        ShowFrame showFrame = new ShowFrame();
        // 绑定
        scene.bind(showFrame);
        // 开始运行
        scene.run();
    }

    // 三体
    public static void threeBody() {
        // 创建宽和高均为300的坐标系
        Scene scene = new Scene(300, 300);
        // 设置delta-t，越大越快
        scene.interval = 1;
        // 恒星1
        scene.ballList.add(new Ball(5000, new Vector(50, 0), new Vector(-0.3, -0.8)));
        // 恒星2
        scene.ballList.add(new Ball(5000, new Vector(-50, 0), new Vector(0.1, 0.8)));
        // 恒星3
        scene.ballList.add(new Ball(5000, new Vector(0, 50), new Vector(0.2, 0)));
        // 创建显示窗体（一切默认）
        ShowFrame showFrame = new ShowFrame();
        // 绑定
        scene.bind(showFrame);
        // 开始运行
        scene.run();
    }
}
