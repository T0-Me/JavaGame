package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class Littleboss1bulletObj extends GameObj{

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Littleboss1bulletObj() {
        super();
    }

    public Littleboss1bulletObj(int x, int y) {
        super(x, y);
    }

    public Littleboss1bulletObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public Littleboss1bulletObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;

        if (this.getRec().intersects(this.frame.playerObj.getRec())){
//            System.out.println("阵亡");
            Gamewin.state = 3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
