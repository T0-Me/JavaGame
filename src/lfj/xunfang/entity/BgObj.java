package lfj.xunfang.entity;

import java.awt.*;

public class BgObj extends GameObj{

    public BgObj(){
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    //重写绘制方法
    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //每次绘制完成图片后，给y轴一个正向的速度，向下移动
        y += speed;
        //判断：如果背景图片超过了面板，那么重新设置y轴的位置
        if(y >= 0) {
            y = -1966;
        }
    }
}
