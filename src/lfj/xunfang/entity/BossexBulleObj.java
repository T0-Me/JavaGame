package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class BossexBulleObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BossexBulleObj() {
        super();
    }

    public BossexBulleObj(int x, int y) {
        super(x, y);
    }

    public BossexBulleObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BossexBulleObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y  += speed;

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
