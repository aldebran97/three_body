package com.aldebran;

import javax.swing.*;
import java.awt.*;

/**
 * 展示窗体
 *
 * @author aldebran
 * @since 2021-09-17
 */
public class ShowFrame extends JFrame {

    public static int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // 屏幕宽度

    public static int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); // 屏幕高度

    private static int defaultInitW = 1000; // 默认宽度

    private static int defaultInitH = 800; // 默认高度

    private static String defaultTitle = "N体问题程序"; // 默认标题

    private int initW; // 初始宽度

    private int initH; // 初始高度

    public Scene scene;

    // 关键面板
    public JPanel jPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            int w = getWidth();
            int h = getHeight();
            Image image = createImage(w, h);
            Graphics g2 = image.getGraphics();
            int r = 5;
            if (scene != null) {
                for (Ball ball : scene.ballList) {
                    g2.setColor(ball.color);
                    double x = ball.position.get(0);
                    double y = ball.position.get(1);
                    double x2 = (x - scene.xMin) * 1.0 / (scene.xMax - scene.xMin) * w - r;
                    double y2 = (h - (y - scene.yMin) * 1.0 / (scene.yMax - scene.yMin) * h) - r;
                    g2.fillOval((int) x2, (int) y2, r * 2, r * 2);
                }
            }
            g.drawImage(image, 0, 0, null);
        }


    };


    public ShowFrame() {
        super(defaultTitle);
        this.initH = defaultInitH;
        this.initW = defaultInitW;
        setSize(initW, initH);
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel);
        jPanel.setSize(initW, initH);
    }

    /**
     * 构造方法
     *
     * @param w     宽度
     * @param h     高度
     * @param title 标题
     */
    public ShowFrame(int w, int h, String title) {
        super(title);
        this.initH = h;
        this.initW = w;
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel);
        jPanel.setSize(initW, initH);
    }

}
