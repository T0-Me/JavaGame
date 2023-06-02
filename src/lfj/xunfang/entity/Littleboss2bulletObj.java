package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class Littleboss2bulletObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Littleboss2bulletObj(int x, int y) {
        super(x, y);
    }

    public Littleboss2bulletObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public Littleboss2bulletObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        this.x -= (this.x - Gameutils.gameObjList.get(Gamewin.planindix).getX()) / 30;

        //检测导弹和飞机的碰撞
        if (this.getRec().intersects(this.frame.playerObj.getRec())){
//            System.out.println("阵亡");
            Gamewin.state = 3;
        }
        //以及导弹和我方子弹的检测  首先拿到所有的我方子弹
        for (ShallObj shallObj:Gameutils.shellObjlist){
            if(this.getRec().intersects(shallObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                //爆炸效果产生
                Gameutils.explodeObjList.add(explodeObj);
                //完成后移除
                Gameutils.removeObjList.add(explodeObj);
                shallObj.setX(-200);
                shallObj.setY(-200);
                Gameutils.removeObjList.add(shallObj);
                this.setX(-200);
                this.setY(-200);
                Gameutils.removeObjList.add(this);
            }
        }

        //以及导弹和我方子弹的检测  首先拿到所有的我方子弹
        for (DoubleshellObj doubleshellObj:Gameutils.doubleshellObjList){
            if(this.getRec().intersects(doubleshellObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                //爆炸效果产生
                Gameutils.explodeObjList.add(explodeObj);
                //完成后移除
                Gameutils.removeObjList.add(explodeObj);
                doubleshellObj.setX(-200);
                doubleshellObj.setY(-200);
                Gameutils.removeObjList.add(doubleshellObj);
                this.setX(-200);
                this.setY(-200);
                Gameutils.removeObjList.add(this);
            }
        }

        //以及导弹和我方子弹的检测  首先拿到所有的我方子弹
        for (TripleshellObj tripleshellObj:Gameutils.tripleshellObjList){
            if(this.getRec().intersects(tripleshellObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                //爆炸效果产生
                Gameutils.explodeObjList.add(explodeObj);
                //完成后移除
                Gameutils.removeObjList.add(explodeObj);
                tripleshellObj.setX(-500);
                tripleshellObj.setY(-500);
                Gameutils.removeObjList.add(tripleshellObj);
                this.setX(-500);
                this.setY(-500);
                Gameutils.removeObjList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
