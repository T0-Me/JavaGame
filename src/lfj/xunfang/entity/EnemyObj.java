package lfj.xunfang.entity;

import jdk.jshell.JShell;
import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

//敌方飞机的类
public class EnemyObj extends GameObj{
    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //敌机向下移动
        y += speed;

        if(y > 700){
            this.setX(-300);
            this.setY(-300);
            Gameutils.removeObjList.add(this);
        }

        //敌我飞机碰撞检查
        if(this.getRec().intersects(this.frame.playerObj.getRec())){
            //如果检测成功，则游戏结束
            this.setX(-200);
            this.setY(-200);
            Gameutils.removeObjList.add(this);

            Gamewin.heard--;
            if(Gamewin.heard <= 0){
                Gamewin.state = 3;
            }
        }

        //遍历子弹的集合，让敌机和每一颗子弹都进行碰撞检测
        for (ShallObj shallObj : Gameutils.shellObjlist) {
            //intersects 方法：用于矩形的碰撞检测 true：碰到了 false；没有碰到
            //this.getRec()：获取敌机的矩形范围
            if (this.getRec().intersects(shallObj.getRec())) {
                //创建爆炸对象
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                //将爆炸对象放入爆炸集合
                Gameutils.explodeObjList.add(explodeObj);
                //爆炸完成后移除
                Gameutils.removeObjList.add(explodeObj);
                //System.out.println("敌机与子弹碰撞");
                //改变子弹和敌机的位置，防止子弹和敌机留坑影响后续飞机
                shallObj.setX(-100);
                shallObj.setY(100);
                this.x = -200;
                this.y = 200;

                //将碰撞的敌机和子弹放入要删除的集合
                Gameutils.removeObjList.add(shallObj);
                Gameutils.removeObjList.add(this);

                //击落一架敌机，分数加1
                Gamewin.souce+=1;
            }

            //遍历子弹的集合，让敌机和每一颗子弹都进行碰撞检测
            for (DoubleshellObj doubleshellObj : Gameutils.doubleshellObjList) {
                //intersects 方法：用于矩形的碰撞检测 true：碰到了 false；没有碰到
                //this.getRec()：获取敌机的矩形范围
                if (this.getRec().intersects(doubleshellObj.getRec())) {
                    //创建爆炸对象
                    ExplodeObj explodeObj = new ExplodeObj(x, y);
                    //将爆炸对象放入爆炸集合
                    Gameutils.explodeObjList.add(explodeObj);
                    //爆炸完成后移除
                    Gameutils.removeObjList.add(explodeObj);
                    //System.out.println("敌机与子弹碰撞");
                    //改变子弹和敌机的位置，防止子弹和敌机留坑影响后续飞机
                    doubleshellObj.setX(-300);
                    doubleshellObj.setY(300);
                    this.x = -200;
                    this.y = 200;

                    //将碰撞的敌机和子弹放入要删除的集合
                    Gameutils.removeObjList.add(doubleshellObj);
                    Gameutils.removeObjList.add(this);

                    //击落一架敌机，分数加1
                    Gamewin.souce += 1;
                }
            }
            //遍历子弹的集合，让敌机和每一颗子弹都进行碰撞检测
            for (TripleshellObj tripleshellObj : Gameutils.tripleshellObjList) {
                //intersects 方法：用于矩形的碰撞检测 true：碰到了 false；没有碰到
                //this.getRec()：获取敌机的矩形范围
                if (this.getRec().intersects(tripleshellObj.getRec())) {
                    //创建爆炸对象
                    ExplodeObj explodeObj = new ExplodeObj(x, y);
                    //将爆炸对象放入爆炸集合
                    Gameutils.explodeObjList.add(explodeObj);
                    //爆炸完成后移除
                    Gameutils.removeObjList.add(explodeObj);
                    //System.out.println("敌机与子弹碰撞");
                    //改变子弹和敌机的位置，防止子弹和敌机留坑影响后续飞机
                    tripleshellObj.setX(-300);
                    tripleshellObj.setY(300);
                    this.x = -200;
                    this.y = 200;

                    //将碰撞的敌机和子弹放入要删除的集合
                    Gameutils.removeObjList.add(tripleshellObj);
                    Gameutils.removeObjList.add(this);

                    //击落一架敌机，分数加1
                    Gamewin.souce += 1;
                }
            }
        }
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public EnemyObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public EnemyObj() {

    }
}
