package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerObj extends GameObj{

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //每次绘制飞机的时候，监听鼠标的位置，让飞机和鼠标的位置一致
        //对当前窗口对象进行监听，监听鼠标移动
        this.frame.addMouseMotionListener(new MouseAdapter() {

            //当鼠标移动时会执行此方法
            //将鼠标的xy位置参数设为玩家飞机的位置参数
            //将鼠标移动到飞机的中点
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX() - width/2;
                y = e.getY() - height/2;
            }
        });

        //检测战利品与飞机的碰撞
        for (GiftObj giftObj : Gameutils.giftObjList
             ) {
            if (this.getRec().intersects(giftObj.getRec())){
                giftObj.setX(-300);
                giftObj.setY(-300);
                Gameutils.removeObjList.add(giftObj);
                Gamewin.shallCount++;
            }
        }
    }

    public PlayerObj() {
    }

    public PlayerObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public PlayerObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }
}
