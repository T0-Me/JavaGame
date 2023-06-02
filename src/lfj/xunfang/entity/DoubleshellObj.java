package lfj.xunfang.entity;

import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class DoubleshellObj extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public DoubleshellObj() {
        super();
    }

    public DoubleshellObj(int x, int y) {
        super(x, y);
    }

    public DoubleshellObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public DoubleshellObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
