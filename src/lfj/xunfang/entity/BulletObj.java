package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

//敌方子弹的类
public class BulletObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BulletObj() {
        super();
    }

    public BulletObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BulletObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //敌机子弹向下移动
        y += speed;

        if(y > 700){
            this.setX(-200);
            this.setY(-200);
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
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
