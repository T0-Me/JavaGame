package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

//定义游戏的父类
public class GameObj {
    //定义游戏的一些属性
    //图片
    public Image img;
    //x轴坐标
    public int x;
    //y轴坐标
    public int y;
    //定义宽度
    public int width;
    //定义高度
    public int height;
    //定义速度
    public double speed;
    //定义游戏的窗口对象
    public Gamewin frame; //对象属性

    //属性的get方法
    public Image getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

    public Gamewin getFrame() {
        return frame;
    }

    //属性的set方法——构造方法
    public GameObj(){
    }

    public GameObj(int x , int y){
        this.x = x;
        this.y = y;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    //封装绘制图片的方法
    public void paintSelf(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //获取自身矩形的方法 ， 用于碰撞检测
    //Rectangle:矩形对象
    //确定了当前碰撞的矩形的位置和范围
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
