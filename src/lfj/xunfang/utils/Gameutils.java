package lfj.xunfang.utils;

import lfj.xunfang.entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//游戏工具类 = 图片等
public class Gameutils {

    //背景图片
    public static Image bgImg = new ImageIcon(Gameutils.class.getResource("../imgs/space.jpg")).getImage();

    //BOSS图片
    public static Image bossImg = new ImageIcon(Gameutils.class.getResource("../imgs/boss2.png")).getImage();

    //敌方子弹图片
    public static Image bulletImg = new ImageIcon(Gameutils.class.getResource("../imgs/bullet.png")).getImage();

    //爆炸图片
    public static Image boomImg = new ImageIcon(Gameutils.class.getResource("../imgs/explode/e10.gif")).getImage();

    //boss爆炸图片
    public static Image bossboomImg = new ImageIcon(Gameutils.class.getResource("../imgs/explode/e9.gif")).getImage();

    //玩家图片
    public static Image playerImg = new ImageIcon(Gameutils.class.getResource("../imgs/hero.png")).getImage();

    //玩家战斗机子弹
    public static Image shallImg = new ImageIcon(Gameutils.class.getResource("../imgs/shell.png")).getImage();

    //战利品的图片
    public static Image fireImg = new ImageIcon(Gameutils.class.getResource("../imgs/fire.png")).getImage();

    //战利品图片
    public static Image giftImg = new ImageIcon(Gameutils.class.getResource("../imgs/gift.png")).getImage();

    //危险警示图片
    public static Image warninImg = new ImageIcon(Gameutils.class.getResource("../imgs/warning.gif")).getImage();

    //小BOSS图片
    public static Image xbossImg = new ImageIcon(Gameutils.class.getResource("../imgs/boss.png")).getImage();

    //小BOSS 1 的图片
    public static Image xboss1Img = new ImageIcon(Gameutils.class.getResource("../imgs/boss1.png")).getImage();

    //跟踪弹图片1
    public static Image boss1bulletImg = new ImageIcon(Gameutils.class.getResource("../imgs/littleboss1bullet.png")).getImage();

    //跟踪弹图片2
    public static Image boss2bulletImg = new ImageIcon(Gameutils.class.getResource("../imgs/littleboss2bullet.png")).getImage();

    //2号子弹
    public static Image doubleshellImg = new ImageIcon(Gameutils.class.getResource("../imgs/doubleshell.png")).getImage();

    //3号子弹
    public static Image tripleshellImg = new ImageIcon(Gameutils.class.getResource("../imgs/tripleshell.png")).getImage();

    //玩家血量图片
    public static Image bloodImg = new ImageIcon(Gameutils.class.getResource("../imgs/hero_blood.png")).getImage();

//    //背景音乐
//    public static Image song = new ImageIcon(Gameutils.class.get("../imgs/game_music.wav")).get();


    //敌方boss大招图片
    public static Image bossexbulletImg = new ImageIcon(Gameutils.class.getResource("../imgs/bossbullet.png")).getImage();


    //我方战斗机子弹的集合
    public static List<ShallObj> shellObjlist = new ArrayList<>();

    //敌方战斗机的集合
    public static List<EnemyObj> enemyObjlist = new ArrayList<>();

    //所有物体集合
    public static List<GameObj> gameObjList = new ArrayList<>();

    //游戏中要被删除的物体的集合
    public static List<GameObj> removeObjList = new ArrayList<>();

    //敌方子弹集合
    public static List<BulletObj> bulletObjsList = new ArrayList<>();

    //绿色小BOSS的子弹的集合
    public static List<Littleboss1bulletObj> littleboss1bulletObjList = new ArrayList<>();

    //绿色boss集合
    public static List<Xboss1Obj> xboss1ObjList = new ArrayList<>();

    //定义计分板
    public static void doraw(Graphics graphics,String str,Color color,int x,int y,int size){
        graphics.setColor(color);
        graphics.setFont(new Font("微软清雅",Font.BOLD,size));
        graphics.drawString(str,x,y);
    }

    //创建爆炸类的集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    //小BOSS集合
    public static List<XbossObj> xbossObjList = new ArrayList<>();

    //跟踪弹集合
    public static List<Littleboss2bulletObj> littleboss2bulletObjList = new ArrayList<>();

    //战利品的集合
    public static List<GiftObj> giftObjList = new ArrayList<>();

    //子弹集合
    public static List<DoubleshellObj> doubleshellObjList = new ArrayList<>();
    public static List<TripleshellObj> tripleshellObjList = new ArrayList<>();

    //玩家血量集合
    public static List<BloodObj> bloodObjList = new ArrayList<>();

    //Boss大招集合
    public static List<BossexBulleObj> bossexBulleObjList = new ArrayList<>();
}
