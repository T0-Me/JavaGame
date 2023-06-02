package lfj.xunfang.entity;

import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class WarningObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public WarningObj(int x, int y) {
        super(x, y);
    }

    public WarningObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public WarningObj(Image img, int x, int y, double speed) {
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
