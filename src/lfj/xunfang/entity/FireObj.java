package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class FireObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public FireObj(int x, int y) {
        super(x, y);
    }

    public FireObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public FireObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if(y > 700){
            this.setX(-200);
            this.setY(-200);
            Gameutils.removeObjList.add(this);
        }

        //判断和玩家的碰撞
        if(this.getRec().intersects(this.frame.playerObj.getRec())){
            System.out.println("子弹加一");
            this.setX(-200);
            this.setY(-200);
            Gameutils.removeObjList.add(this);
            if(Gamewin.heard < 3){
                Gamewin.heard++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
