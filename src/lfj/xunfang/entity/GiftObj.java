package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class GiftObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public GiftObj() {
        super();
    }

    public GiftObj(int x, int y) {
        super(x, y);
    }

    public GiftObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public GiftObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        //获取战利品图片
        super.img = Gameutils.giftImg;
        super.width = 64;
        super.height = 62;
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
