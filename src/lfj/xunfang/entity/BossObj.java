package lfj.xunfang.entity;

import jdk.jshell.JShell;
import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.xf1.Gamewin;

import java.awt.*;

//Boss的类
public class BossObj extends GameObj{

    //定义boss血量
    int boss = 50;

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(x > 242 || x < 0)
        {
            speed = -speed;
        }
        x += speed;

        //检测玩家和boss的碰撞
        if(this.getRec().intersects(this.frame.playerObj.getRec()) && this.frame.bossObj != null){
            Gamewin.state = 3;
        }

        //遍历所有的子弹，检测是否与boss发生碰撞
        for (ShallObj shallobj:
                Gameutils.shellObjlist) {
            if(this.getRec().intersects(shallobj.getRec())){
                //移除子弹
                shallobj.setX(-100);
                shallobj.setY(100);
                Gameutils.removeObjList.add(shallobj);
                //击中boss后，boss血量降低
                boss--;
//                System.out.println("boss血量为"+boss);
            }
        }

        for (DoubleshellObj doubleshellObj:
                Gameutils.doubleshellObjList) {
            if(this.getRec().intersects(doubleshellObj.getRec())){
                //移除子弹
                doubleshellObj.setX(-100);
                doubleshellObj.setY(100);
                Gameutils.removeObjList.add(doubleshellObj);
                //击中boss后，boss血量降低
                boss -= 2;
//                System.out.println("boss血量为"+boss);
            }
        }

        for (TripleshellObj tripleshellObj:
                Gameutils.tripleshellObjList) {
            if(this.getRec().intersects(tripleshellObj.getRec())){
                //移除子弹
                tripleshellObj.setX(-100);
                tripleshellObj.setY(100);
                Gameutils.removeObjList.add(tripleshellObj);
                //击中boss后，boss血量降低
                boss -= 4;
//                System.out.println("boss血量为"+boss);
            }
        }

        if(boss < 1){
            Gamewin.state = 4;
        }

        //给boss绘制血条
        //boss总血量
        gImage.setColor(Color.WHITE);
        gImage.fillRect(20,40,100,10);
        //boss残余血量
        gImage.setColor(Color.RED);
        gImage.fillRect(20,40,boss*10/100,10);

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
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public BossObj() {
    }

    public BossObj(Image img, int x, int y, int width, int height, double speed, Gamewin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BossObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

}
