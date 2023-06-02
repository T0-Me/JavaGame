package lfj.xunfang.entity;

import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

public class Xboss1Obj extends GameObj{

    public Xboss1Obj() {
        super();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Xboss1Obj(int x, int y) {
        super(x, y);
    }

    public Xboss1Obj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public Xboss1Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //让boss先往右移动，到达四百后向左
        if (x > 400){
            speed = -speed;
        }
        x+= speed;

        //检测子弹打到小BOSS
        for (ShallObj shallObj: Gameutils.shellObjlist){
            if(this.getRec().intersects(shallObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
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
                Gamewin.souce += 2;
            }
        }

        //检测子弹打到小BOSS
        for (DoubleshellObj doubleshellObj: Gameutils.doubleshellObjList){
            if(this.getRec().intersects(doubleshellObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
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
                Gamewin.souce += 2;
            }
        }

        //检测子弹打到小BOSS
        for (TripleshellObj tripleshellObj: Gameutils.tripleshellObjList){
            if(this.getRec().intersects(tripleshellObj.getRec())){
//                System.out.println("爆炸");
                ExplodeObj explodeObj = new ExplodeObj(x,y);
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
                Gamewin.souce += 2;
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
