package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class XbossObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public XbossObj(int x, int y) {
        super(x, y);
    }

    public XbossObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public XbossObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(y < 150){
            y += speed;
        }else{
            if(x > 300 || x < 10){
                speed = -speed;
            }
            x += speed;
        }

        //检测子弹打到小BOSS
        if (this.getY() > 148) {
            for (ShallObj shallObj : Gameutils.shellObjlist) {
                if (this.getRec().intersects(shallObj.getRec())) {
                    //                System.out.println("爆炸");
                    ExplodeObj explodeObj = new ExplodeObj(x, y);
                    //爆炸效果产生
                    Gameutils.explodeObjList.add(explodeObj);
                    //完成后移除
                    Gameutils.removeObjList.add(explodeObj);

                    GiftObj giftObj = new GiftObj(this.x, this.y);
                    Gameutils.giftObjList.add(giftObj);
                    Gameutils.gameObjList.addAll(Gameutils.giftObjList);

                    shallObj.setX(-200);
                    shallObj.setY(-200);
                    Gameutils.removeObjList.add(shallObj);
                    this.setX(-300);
                    this.setY(-300);
                    Gameutils.removeObjList.add(this);
                }
            }
        }

        //检测子弹打到小BOSS
        if (this.getY() > 148) {
            for (DoubleshellObj doubleshellObj : Gameutils.doubleshellObjList) {
                if (this.getRec().intersects(doubleshellObj.getRec())) {
                    //                System.out.println("爆炸");
                    ExplodeObj explodeObj = new ExplodeObj(x, y);
                    //爆炸效果产生
                    Gameutils.explodeObjList.add(explodeObj);
                    //完成后移除
                    Gameutils.removeObjList.add(explodeObj);

                    GiftObj giftObj = new GiftObj(this.x, this.y);
                    Gameutils.giftObjList.add(giftObj);
                    Gameutils.gameObjList.addAll(Gameutils.giftObjList);

                    doubleshellObj.setX(-200);
                    doubleshellObj.setY(-200);
                    Gameutils.removeObjList.add(doubleshellObj);
                    this.setX(-300);
                    this.setY(-300);
                    Gameutils.removeObjList.add(this);
                }
            }
        }

        //检测子弹打到小BOSS
        if (this.getY() > 148) {
            for (TripleshellObj tripleshellObj : Gameutils.tripleshellObjList) {
                if (this.getRec().intersects(tripleshellObj.getRec())) {
                    //                System.out.println("爆炸");
                    ExplodeObj explodeObj = new ExplodeObj(x, y);
                    //爆炸效果产生
                    Gameutils.explodeObjList.add(explodeObj);
                    //完成后移除
                    Gameutils.removeObjList.add(explodeObj);

                    GiftObj giftObj = new GiftObj(this.x, this.y);
                    Gameutils.giftObjList.add(giftObj);
                    Gameutils.gameObjList.addAll(Gameutils.giftObjList);

                    tripleshellObj.setX(-200);
                    tripleshellObj.setY(-200);
                    Gameutils.removeObjList.add(tripleshellObj);
                    this.setX(-300);
                    this.setY(-300);
                    Gameutils.removeObjList.add(this);
                }
            }
        }

        //敌我飞机碰撞检查
        if(this.getRec().intersects(this.frame.playerObj.getRec())){
            //如果检测成功，则游戏结束
            this.setX(-200);
            this.setY(-200);
            Gameutils.removeObjList.add(this);

            Gamewin.heard--;
            if(Gamewin.heard <= 0){
                Gamewin.state = 3;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
