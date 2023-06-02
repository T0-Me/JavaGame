package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

//我方子弹的物体类
public class ShallObj extends GameObj{

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //让子弹向上移动
        y -= speed;
        //当子弹超出屏幕，则将子弹移除
        if(y < 0){
            this.setX(-100);
            this.setY(-100);
            //超出屏幕的子弹移除
            Gameutils.removeObjList.add(this);
        }
    }

    public ShallObj() {
    }

    public ShallObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public ShallObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }
}
