package lfj.xunfang.entity;

import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class BloodObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BloodObj() {
        super();
    }

    public BloodObj(int x, int y) {
        super(x, y);
    }

    public BloodObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BloodObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
