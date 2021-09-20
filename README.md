# three_body

三体运动模拟和可视化(three-body motion simulation and visualization)

### 1. 可以模拟多体运动(N >= 2)
### 2. 支持碰撞（动量守恒，动能不守恒）

## 三体模拟示例（三恒星）

注：
1. Ball的构造方法中，第一个参数是质量，第二个参数是位置，第三个参数是速度。
2. Ball对象可以修改半径和颜色，半径越小越不容易发生碰撞

```java
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
```

## 三恒星+2行星示例

```java
// 三恒星
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
```

## 单恒星+2行星
```java
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
```

## 三恒星+单行星
```java
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
```