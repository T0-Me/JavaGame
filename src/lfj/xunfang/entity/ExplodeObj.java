package lfj.xunfang.entity;
//爆炸类
import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import javax.swing.*;
import java.awt.*;

public class ExplodeObj extends GameObj{

    //存放爆炸类的图片
    public static  Image[] pic = new Image[16];

    int expcount = 0;

    static {
        //数组长度——length   集合长度——size()
        for (int i=0 ; i< pic.length ; i++){
            pic[i] = new ImageIcon(Gamewin.class.getResource("../imgs/explode/e"+(i+1)+".gif")).getImage();
        }
    }

    public ExplodeObj(int x, int y) {
        super(x,y);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ExplodeObj() {
        super();
    }

    public ExplodeObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public ExplodeObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {

        //当expcount等于16时，就不做自加了
        if(expcount < 16){
            img = pic[expcount];
            super.paintSelf(gImage);
            expcount++;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
